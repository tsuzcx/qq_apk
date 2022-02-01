package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.tx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;
import com.tencent.mm.ui.widget.listview.PullDownListView.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

@com.tencent.mm.kernel.k
public class ContactInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h, f.a, com.tencent.mm.plugin.messenger.foundation.a.a.n.a, com.tencent.mm.plugin.story.api.g, com.tencent.mm.plugin.textstatus.a.i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private long AxK;
  private View Inv;
  private com.tencent.mm.ui.statusbar.c.a Inw;
  private boolean MVA;
  private AbsStoryMuteView MVB;
  private boolean MVC;
  private boolean MVD;
  private boolean MVE;
  private boolean MVF;
  private int MVG;
  private com.tencent.mm.plugin.textstatus.a.b MVH;
  private View.OnClickListener MVI;
  private PullDownListView.IPullDownCallback MVJ;
  private PullDownListView.IPullDownCallback MVK;
  private View MVL;
  private boolean MVM;
  private ContactWidgetTabBizInfo MVN;
  private String MVO;
  private long MVP;
  private View MVQ;
  private View.OnLayoutChangeListener MVR;
  Runnable MVS;
  private com.tencent.mm.pluginsdk.c.a MVr;
  private NormalProfileHeaderPreference MVs;
  private boolean MVt;
  private boolean MVu;
  private byte[] MVv;
  private boolean MVw;
  String MVx;
  private String MVy;
  private PullDownListView MVz;
  private String MoA;
  private au contact;
  private boolean nKe;
  private String pPi;
  private int pUt;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private AbsStoryGallery storyGallery;
  private com.tencent.mm.pluginsdk.ui.span.m vIA;
  
  public ContactInfoUI()
  {
    AppMethodBeat.i(26982);
    this.MVw = false;
    this.MVx = null;
    this.MVy = "";
    this.roomId = "";
    this.MoA = "";
    this.MVz = null;
    this.MVA = false;
    this.storyGallery = null;
    this.MVB = null;
    this.MVC = false;
    this.MVD = false;
    this.MVE = false;
    this.MVF = false;
    this.nKe = false;
    this.MVG = 0;
    this.AxK = 0L;
    this.MVH = null;
    this.MVI = null;
    this.MVJ = new PullDownListView.IPullDownCallback()
    {
      public final void afI(int paramAnonymousInt)
      {
        AppMethodBeat.i(26966);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).amX(paramAnonymousInt);
        }
        AppMethodBeat.o(26966);
      }
      
      public final void afJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(26967);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).amY(paramAnonymousInt);
        }
        AppMethodBeat.o(26967);
      }
      
      public final void afK(int paramAnonymousInt) {}
      
      public final void etL()
      {
        AppMethodBeat.i(26962);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).huA();
        }
        AppMethodBeat.o(26962);
      }
      
      public final void etM()
      {
        AppMethodBeat.i(26963);
        if (ContactInfoUI.a(ContactInfoUI.this) != null) {
          ContactInfoUI.a(ContactInfoUI.this).huB();
        }
        AppMethodBeat.o(26963);
      }
      
      public final void gBu()
      {
        AppMethodBeat.i(26964);
        Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
        ContactInfoUI.d(ContactInfoUI.this).huH();
        AppMethodBeat.o(26964);
      }
      
      public final void gBv()
      {
        AppMethodBeat.i(26965);
        ContactInfoUI.d(ContactInfoUI.this).huI();
        AppMethodBeat.o(26965);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(26961);
        if (ContactInfoUI.a(ContactInfoUI.this) != null)
        {
          Log.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
          ContactInfoUI.a(ContactInfoUI.this).ED(true);
          ContactInfoUI.this.showTitleView();
          ContactInfoUI.c(ContactInfoUI.this);
        }
        AppMethodBeat.o(26961);
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(26960);
        if (ContactInfoUI.a(ContactInfoUI.this) != null)
        {
          Log.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
          ContactInfoUI.a(ContactInfoUI.this).ba(paramAnonymousBoolean, true);
          ContactInfoUI.this.hideTitleView();
          ContactInfoUI.b(ContactInfoUI.this);
        }
        AppMethodBeat.o(26960);
      }
    };
    this.MVK = new PullDownListView.IPullDownCallback()
    {
      public final void afI(int paramAnonymousInt) {}
      
      public final void afJ(int paramAnonymousInt) {}
      
      public final void afK(int paramAnonymousInt) {}
      
      public final void etL()
      {
        AppMethodBeat.i(305616);
        if (ContactInfoUI.e(ContactInfoUI.this) != null)
        {
          ContactInfoUI.e(ContactInfoUI.this).etL();
          if (ContactInfoUI.h(ContactInfoUI.this) != null)
          {
            Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.h(ContactInfoUI.this).bAi("contact_profile_header_normal");
            if (localObject != null)
            {
              localObject = ((NormalProfileHeaderPreference)localObject).gBi();
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.g)localObject).etL();
              }
            }
          }
        }
        AppMethodBeat.o(305616);
      }
      
      public final void etM()
      {
        AppMethodBeat.i(305619);
        if (ContactInfoUI.e(ContactInfoUI.this) != null)
        {
          ContactInfoUI.e(ContactInfoUI.this).etM();
          if (ContactInfoUI.h(ContactInfoUI.this) != null)
          {
            Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.h(ContactInfoUI.this).bAi("contact_profile_header_normal");
            if (localObject != null)
            {
              localObject = ((NormalProfileHeaderPreference)localObject).gBi();
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.g)localObject).etM();
              }
            }
          }
        }
        AppMethodBeat.o(305619);
      }
      
      public final void gBu()
      {
        AppMethodBeat.i(305621);
        Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
        if (ContactInfoUI.d(ContactInfoUI.this) != null) {
          ContactInfoUI.d(ContactInfoUI.this).huH();
        }
        AppMethodBeat.o(305621);
      }
      
      public final void gBv()
      {
        AppMethodBeat.i(305623);
        if (ContactInfoUI.d(ContactInfoUI.this) != null) {
          ContactInfoUI.d(ContactInfoUI.this).huI();
        }
        AppMethodBeat.o(305623);
      }
      
      public final void onPostClose()
      {
        AppMethodBeat.i(305615);
        if (ContactInfoUI.e(ContactInfoUI.this) != null) {
          ContactInfoUI.e(ContactInfoUI.this).onPostClose();
        }
        if (ContactInfoUI.h(ContactInfoUI.this) != null)
        {
          Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.h(ContactInfoUI.this).bAi("contact_profile_header_normal");
          if (localObject != null)
          {
            localObject = ((NormalProfileHeaderPreference)localObject).gBi();
            if (localObject != null) {
              ((com.tencent.mm.plugin.textstatus.a.g)localObject).onPostClose();
            }
          }
        }
        ContactInfoUI.this.showTitleView();
        ContactInfoUI.i(ContactInfoUI.this);
        AppMethodBeat.o(305615);
      }
      
      public final void onPostOpen(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305611);
        if (ContactInfoUI.e(ContactInfoUI.this) != null) {
          ContactInfoUI.e(ContactInfoUI.this).onPostOpen(paramAnonymousBoolean);
        }
        com.tencent.mm.plugin.textstatus.a.g localg = ContactInfoUI.f(ContactInfoUI.this);
        if (localg != null) {
          localg.onPostOpen(paramAnonymousBoolean);
        }
        ContactInfoUI.this.hideTitleView();
        ContactInfoUI.g(ContactInfoUI.this);
        AppMethodBeat.o(305611);
      }
    };
    this.vIA = new com.tencent.mm.pluginsdk.ui.span.m()
    {
      public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(305482);
        switch (paramAnonymousu.type)
        {
        default: 
          AppMethodBeat.o(305482);
          return null;
        }
        if (ContactInfoUI.j(ContactInfoUI.this) != null)
        {
          paramAnonymousu = ContactInfoUI.j(ContactInfoUI.this).field_username;
          AppMethodBeat.o(305482);
          return paramAnonymousu;
        }
        AppMethodBeat.o(305482);
        return null;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(305490);
        String str2;
        String str1;
        Object localObject1;
        if (paramAnonymousu.type == 45)
        {
          str2 = new String(Base64.decode(paramAnonymousu.url, 0));
          str1 = (String)paramAnonymousu.cf(String.class);
          paramAnonymousu = "";
          localObject1 = paramAnonymousu;
        }
        label266:
        for (;;)
        {
          try
          {
            Object localObject2 = new com.tencent.mm.ad.i(str1);
            localObject1 = paramAnonymousu;
            paramAnonymousu = ((com.tencent.mm.ad.i)localObject2).optString("fullText");
            localObject1 = paramAnonymousu;
            str1 = ((com.tencent.mm.ad.i)localObject2).optString("linkText");
            localObject1 = str1;
            str1 = "";
          }
          catch (com.tencent.mm.ad.g paramAnonymousu)
          {
            try
            {
              str1 = new String(Base64.decode(Util.nullAs(((com.tencent.mm.ad.i)localObject2).optString("path"), ""), 0));
              Log.d("MicroMsg.ContactInfoUI", "appId:%s,path:%s", new Object[] { str2, str1 });
              localObject2 = new AppBrandStatObject();
              ((AppBrandStatObject)localObject2).scene = 1082;
              if (ContactInfoUI.j(ContactInfoUI.this) != null)
              {
                ((AppBrandStatObject)localObject2).hzx = (ContactInfoUI.j(ContactInfoUI.this).field_username + ":2:" + paramAnonymousu + ":" + (String)localObject1 + ":" + str1);
                Log.d("MicroMsg.ContactInfoUI", "sceneNote = %s", new Object[] { ((AppBrandStatObject)localObject2).hzx });
              }
              ((t)com.tencent.mm.kernel.h.ax(t.class)).a(ContactInfoUI.this.getContext(), null, str2, 0, 0, str1, (AppBrandStatObject)localObject2);
              AppMethodBeat.o(305490);
              return null;
            }
            catch (com.tencent.mm.ad.g localg)
            {
              break label266;
            }
            paramAnonymousu = paramAnonymousu;
            str1 = "";
            paramAnonymousu = (com.tencent.mm.pluginsdk.ui.applet.u)localObject1;
            localObject1 = str1;
          }
        }
      }
    };
    this.MVM = false;
    this.MVN = null;
    this.MVO = "";
    this.MVP = 0L;
    this.MVR = new ContactInfoUI.3(this);
    this.MVS = null;
    AppMethodBeat.o(26982);
  }
  
  private View a(View paramView, a<View> parama)
  {
    AppMethodBeat.i(305524);
    if (parama.apply(paramView).booleanValue())
    {
      AppMethodBeat.o(305524);
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = a(paramView.getChildAt(i), parama);
        if (localView != null)
        {
          AppMethodBeat.o(305524);
          return localView;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(305524);
    return null;
  }
  
  private void afH(int paramInt)
  {
    AppMethodBeat.i(305525);
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.MVQ.getLayoutParams();
      if (localLayoutParams.topMargin != paramInt)
      {
        localLayoutParams.topMargin = paramInt;
        this.MVQ.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(305525);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ContactInfoUI", localThrowable, "adjustStatusBgPosition", new Object[0]);
      AppMethodBeat.o(305525);
    }
  }
  
  private com.tencent.mm.plugin.textstatus.a.g gBi()
  {
    AppMethodBeat.i(305520);
    if (this.screen != null)
    {
      Object localObject = (NormalProfileHeaderPreference)this.screen.bAi("contact_profile_header_normal");
      if (localObject != null)
      {
        localObject = ((NormalProfileHeaderPreference)localObject).gBi();
        AppMethodBeat.o(305520);
        return localObject;
      }
    }
    AppMethodBeat.o(305520);
    return null;
  }
  
  private View gBj()
  {
    AppMethodBeat.i(305523);
    Object localObject = (NormalProfileHeaderPreference)this.screen.bAi("contact_profile_header_normal");
    if (localObject != null)
    {
      if (((NormalProfileHeaderPreference)localObject).KKQ != null)
      {
        localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).KKQ.getTag()).pKl;
        AppMethodBeat.o(305523);
        return localObject;
      }
      AppMethodBeat.o(305523);
      return null;
    }
    AppMethodBeat.o(305523);
    return null;
  }
  
  private void gBp()
  {
    AppMethodBeat.i(26987);
    if ((this.Inv == null) || (!com.tencent.mm.ui.statusbar.c.afCQ))
    {
      AppMethodBeat.o(26987);
      return;
    }
    com.tencent.mm.ui.statusbar.c localc = com.tencent.mm.ui.statusbar.c.ch(this);
    localc.b(this.Inw);
    com.tencent.mm.ui.statusbar.c.a local11 = new com.tencent.mm.ui.statusbar.c.a()
    {
      public final void onStatusBarHeightChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(305478);
        if ((ContactInfoUI.k(ContactInfoUI.this)) || (ContactInfoUI.l(ContactInfoUI.this))) {
          ContactInfoUI.m(ContactInfoUI.this).setPadding(0, paramAnonymousInt, 0, 0);
        }
        AppMethodBeat.o(305478);
      }
    };
    this.Inw = local11;
    localc.a(local11);
    getWindow().getDecorView().requestApplyInsets();
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    AppMethodBeat.o(26987);
  }
  
  private void gBq()
  {
    AppMethodBeat.i(27003);
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      getWindow().clearFlags(201327616);
      AppMethodBeat.o(27003);
      return;
    }
    getWindow().clearFlags(1024);
    AppMethodBeat.o(27003);
  }
  
  private void gBr()
  {
    AppMethodBeat.i(305529);
    if (this.MVA)
    {
      AppMethodBeat.o(305529);
      return;
    }
    if ((this.MVr instanceof ContactWidgetTabBizInfo))
    {
      AppMethodBeat.o(305529);
      return;
    }
    if ((this.contact != null) && (au.bwQ(this.contact.field_username)))
    {
      AppMethodBeat.o(305529);
      return;
    }
    Object localObject1 = (RelativeLayout)findViewById(R.h.mm_preference_list_content_root);
    if (localObject1 == null)
    {
      AppMethodBeat.o(305529);
      return;
    }
    Log.i("MicroMsg.ContactInfoUI", "setupStory %s stack %s", new Object[] { this, Util.getStack().toString() });
    this.MVA = true;
    this.MVz = ((PullDownListView)getListView());
    this.MVz.setBackground(bd.by(getContext(), R.d.me_alpha_bg));
    if (this.MVE)
    {
      this.MVz.setBackground(null);
      this.MVz.agiI = this.MVK;
      localObject2 = new View(this);
      this.MVQ = ((View)localObject2);
      ((RelativeLayout)localObject1).addView((View)localObject2, 0);
      Object localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = -1;
      ((RelativeLayout.LayoutParams)localObject3).height = -1;
      ((RelativeLayout.LayoutParams)localObject3).topMargin = bf.bf(getContext()).x;
      ((View)localObject2).setBackgroundColor(getResources().getColor(R.e.BG_0));
      ao.mX(getContext());
      final float f = com.tencent.mm.plugin.textstatus.a.a.ki(getContext());
      this.MVz.setTranslationListener(new PullDownListView.a()
      {
        public final void cS(float paramAnonymousFloat)
        {
          AppMethodBeat.i(305576);
          this.val$v.setTranslationY(paramAnonymousFloat);
          float f1 = paramAnonymousFloat / f;
          if (paramAnonymousFloat < 0.0F) {
            f1 = 0.0F;
          }
          if (paramAnonymousFloat > f) {
            f1 = 1.0F;
          }
          for (;;)
          {
            if (ContactInfoUI.e(ContactInfoUI.this) != null) {
              ContactInfoUI.e(ContactInfoUI.this).w(f1, paramAnonymousFloat, f);
            }
            if (ContactInfoUI.u(ContactInfoUI.this) == null) {
              ContactInfoUI.a(ContactInfoUI.this, (NormalProfileHeaderPreference)ContactInfoUI.h(ContactInfoUI.this).bAi("contact_profile_header_normal"));
            }
            Object localObject;
            if (ContactInfoUI.u(ContactInfoUI.this) != null)
            {
              localObject = ContactInfoUI.u(ContactInfoUI.this);
              if (((NormalProfileHeaderPreference)localObject).KKQ == null) {
                break label248;
              }
              localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).KKQ.getTag()).MYK;
              if (localObject != null)
              {
                float f2 = 1.0F * (1.0F - f1);
                ((View)localObject).setAlpha(f2);
                localObject = ContactInfoUI.u(ContactInfoUI.this);
                if (((NormalProfileHeaderPreference)localObject).KKQ == null) {
                  break label254;
                }
                localObject = ((NormalProfileHeaderPreference.a)((NormalProfileHeaderPreference)localObject).KKQ.getTag()).MYM;
                label195:
                if (localObject != null)
                {
                  if (f2 > 0.0F) {
                    break label260;
                  }
                  ((View)localObject).setVisibility(0);
                }
              }
            }
            for (;;)
            {
              localObject = ContactInfoUI.u(ContactInfoUI.this).gBi();
              if (localObject != null) {
                ((com.tencent.mm.plugin.textstatus.a.g)localObject).w(f1, paramAnonymousFloat, f);
              }
              AppMethodBeat.o(305576);
              return;
              label248:
              localObject = null;
              break;
              label254:
              localObject = null;
              break label195;
              label260:
              ((View)localObject).setVisibility(8);
            }
          }
        }
      });
      localObject2 = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getBackPreview(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(305597);
          if ((ContactInfoUI.v(ContactInfoUI.this) != null) && (!ContactInfoUI.v(ContactInfoUI.this).isVisible)) {
            ContactInfoUI.v(ContactInfoUI.this).jIs();
          }
          AppMethodBeat.o(305597);
        }
      }, true);
      this.MVH = ((com.tencent.mm.plugin.textstatus.a.b)localObject2);
      localObject3 = getIntent().getStringExtra("Contact_User");
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (localObject2 != null) && (((com.tencent.mm.plugin.textstatus.a.b)localObject2).getView() != null))
      {
        ((RelativeLayout)localObject1).addView(((com.tencent.mm.plugin.textstatus.a.b)localObject2).getView(), 0);
        ((com.tencent.mm.plugin.textstatus.a.b)localObject2).hFo();
        ((com.tencent.mm.plugin.textstatus.a.b)localObject2).a(this);
        ((com.tencent.mm.plugin.textstatus.a.b)localObject2).Ds((String)localObject3);
      }
      this.MVz.setNavigationBarHeight(bf.bk(getContext()));
      this.MVI = new ContactInfoUI.6(this);
      localObject1 = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hxW().jjn = 3L;
      AppMethodBeat.o(305529);
      return;
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck())
    {
      AppMethodBeat.o(305529);
      return;
    }
    this.MVz.agiI = this.MVJ;
    int i = -bf.bf(getContext()).y / 10;
    Object localObject2 = new RelativeLayout.LayoutParams(-1, bf.bf(getContext()).y);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (-bf.bk(getContext()));
    if (this.contact.field_username.equals(z.bAM())) {}
    for (this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.Sil, this.roomId);; this.storyGallery = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(this, com.tencent.mm.plugin.story.api.n.a.Sim, this.roomId))
    {
      this.storyGallery.huE();
      this.MVz.G(this.storyGallery, com.tencent.mm.cd.a.bs(getContext(), R.f.flT), i);
      this.storyGallery.setStoryBrowseUIListener(this);
      this.storyGallery.setDataSeed(this.contact.field_username);
      this.storyGallery.a(this.MVz);
      ((RelativeLayout)localObject1).addView(this.storyGallery, 0, (ViewGroup.LayoutParams)localObject2);
      com.tencent.mm.kernel.h.baF();
      this.MVB = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().jY(this);
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.cd.a.bs(getContext(), R.f.flS), com.tencent.mm.cd.a.bs(getContext(), R.f.flS));
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout)localObject1).addView(this.MVB, 0, (ViewGroup.LayoutParams)localObject2);
      this.MVz.setMuteView(this.MVB);
      break;
    }
  }
  
  private void gBs()
  {
    AppMethodBeat.i(27006);
    if (this.nKe)
    {
      aa.makeText(MMApplicationContext.getContext(), getResources().getString(R.l.gWz), 0).show();
      AppMethodBeat.o(27006);
      return;
    }
    if ((this.MVC) && (this.MVz != null)) {
      this.MVz.jIt();
    }
    AppMethodBeat.o(27006);
  }
  
  private void gBt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(27007);
    Log.i("MicroMsg.ContactInfoUI", "updateUIByStory: %s %s %s %s", new Object[] { Boolean.valueOf(this.MVA), Boolean.valueOf(this.MVC), Boolean.valueOf(this.MVE), Boolean.valueOf(this.MVD) });
    label180:
    NormalProfileHeaderPreference localNormalProfileHeaderPreference;
    boolean bool1;
    label225:
    int i;
    if ((this.MVC) && (!this.nKe))
    {
      gBp();
      setActionbarColor(getContext().getResources().getColor(R.e.transparent));
      setMMTitle("");
      if (this.MVz != null)
      {
        this.MVz.setBackground(bd.by(getContext(), R.d.me_alpha_bg));
        this.MVz.setSupportOverscroll(true);
      }
      if (this.MVL != null) {
        this.MVL.setOnClickListener(new ContactInfoUI.7(this));
      }
      if (this.MVz != null)
      {
        if (!this.MVD) {
          break label521;
        }
        this.MVz.setSelector(R.e.BG_0);
      }
      if (this.screen != null)
      {
        localNormalProfileHeaderPreference = (NormalProfileHeaderPreference)this.screen.bAi("contact_profile_header_normal");
        if (localNormalProfileHeaderPreference != null)
        {
          if ((!this.MVC) || (this.nKe)) {
            break label534;
          }
          bool1 = true;
          i = this.MVL.getHeight();
          if ((!this.MVD) || (this.nKe)) {
            break label539;
          }
        }
      }
    }
    for (;;)
    {
      localNormalProfileHeaderPreference.b(bool1, i, bool2);
      setNavigationbarColor(getContext().getResources().getColor(R.e.BG_0));
      AppMethodBeat.o(27007);
      return;
      if ((this.MVD) && (!this.nKe))
      {
        gBp();
        setActionbarColor(getContext().getResources().getColor(R.e.transparent));
        setMMTitle("");
        if (this.MVz != null)
        {
          this.MVz.setBackground(null);
          if ((this.MVH == null) || (!this.MVH.hFr())) {
            break label423;
          }
        }
        label423:
        for (bool1 = true;; bool1 = false)
        {
          this.MVz.setSupportOverscroll(bool1);
          this.MVz.oS(com.tencent.mm.plugin.textstatus.a.a.ki(this), com.tencent.mm.plugin.textstatus.a.a.kk(this)[1]);
          if (this.MVL != null) {
            this.MVL.setOnClickListener(new ContactInfoUI.8(this));
          }
          if (getBounceView() == null) {
            break;
          }
          getBounceView().setBounceEnabled(false);
          break;
        }
      }
      setActionbarColor(getContext().getResources().getColor(R.e.BG_2));
      setMMTitle("");
      if (this.MVz != null)
      {
        this.MVz.setBackground(bd.by(getContext(), R.d.me_normal_bg));
        this.MVz.setSupportOverscroll(false);
      }
      if (this.Inv != null) {
        this.Inv.setPadding(0, 0, 0, 0);
      }
      if (getBounceView() == null) {
        break;
      }
      getBounceView().setBounceEnabled(true);
      break;
      label521:
      this.MVz.setSelector(R.e.transparent);
      break label180;
      label534:
      bool1 = false;
      break label225;
      label539:
      bool2 = false;
    }
  }
  
  public final void a(bs parambs)
  {
    AppMethodBeat.i(305670);
    MMHandlerThread.postToMainThread(new c(this, parambs));
    AppMethodBeat.o(305670);
  }
  
  public final void a(cr paramcr)
  {
    AppMethodBeat.i(27001);
    MMHandlerThread.postToMainThread(new d(this, paramcr));
    AppMethodBeat.o(27001);
  }
  
  public void finish()
  {
    AppMethodBeat.i(27008);
    if (this.MVS != null)
    {
      this.MVS.run();
      AppMethodBeat.o(27008);
      return;
    }
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jjn = 0L;
    super.finish();
    AppMethodBeat.o(27008);
  }
  
  public final void gBk()
  {
    AppMethodBeat.i(26983);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUINoStory");
    this.MVC = false;
    if ((this.MVz != null) && (!this.MVz.isVisible))
    {
      showTitleView();
      gBq();
      this.MVz.jIr();
    }
    gBt();
    AppMethodBeat.o(26983);
  }
  
  public final void gBl()
  {
    AppMethodBeat.i(26984);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIHasStory");
    this.MVC = true;
    if ((this.MVz != null) && (this.MVz.isVisible)) {
      gBt();
    }
    AppMethodBeat.o(26984);
  }
  
  public final void gBm()
  {
    AppMethodBeat.i(26985);
    Log.i("MicroMsg.ContactInfoUI", "story_cat storyUIBackPressed");
    this.MVz.jIr();
    AppMethodBeat.o(26985);
  }
  
  public final void gBn()
  {
    AppMethodBeat.i(305604);
    Log.i("MicroMsg.ContactInfoUI", "statusUINoStatus");
    this.MVD = false;
    if ((this.MVz != null) && (!this.MVz.isVisible))
    {
      showTitleView();
      gBq();
      this.MVz.jIr();
    }
    gBt();
    AppMethodBeat.o(305604);
  }
  
  public final void gBo()
  {
    AppMethodBeat.i(305608);
    Log.i("MicroMsg.ContactInfoUI", "statusUIHasStatus");
    this.MVD = true;
    if ((this.MVz != null) && (this.MVz.isVisible)) {
      gBt();
    }
    AppMethodBeat.o(305608);
  }
  
  public View getBottomView()
  {
    AppMethodBeat.i(305640);
    View localView = super.getBottomView();
    AppMethodBeat.o(305640);
    return localView;
  }
  
  public String getIdentString()
  {
    AppMethodBeat.i(26995);
    if ((this.contact == null) || ((int)this.contact.maN == 0) || (Util.isNullOrNil(this.contact.field_username)))
    {
      AppMethodBeat.o(26995);
      return "";
    }
    Log.i("MicroMsg.ContactInfoUI", "getIdentityString %s", new Object[] { this.contact.field_username });
    if (com.tencent.mm.an.g.Dn(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChat";
    }
    if (com.tencent.mm.an.g.MB(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseFatherBiz";
    }
    if (com.tencent.mm.an.g.MA(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_EnterpriseChildBiz";
    }
    if (this.contact.iZC())
    {
      AppMethodBeat.o(26995);
      return "_bizContact";
    }
    if (au.bwE(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_chatroom";
    }
    if (au.bwS(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_bottle";
    }
    if (au.bwN(this.contact.field_username))
    {
      AppMethodBeat.o(26995);
      return "_QQ";
    }
    if (ab.IV(this.contact.field_username))
    {
      String str = "_" + this.contact.field_username;
      AppMethodBeat.o(26995);
      return str;
    }
    AppMethodBeat.o(26995);
    return "";
  }
  
  public int getResourceId()
  {
    return R.o.haZ;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(305593);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(a.class);
    AppMethodBeat.o(305593);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26996);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.pPi = getIntent().getStringExtra("Verify_ticket");
    this.MVt = getIntent().getBooleanExtra("Chat_Readonly", false);
    this.MVu = getIntent().getBooleanExtra("User_Verify", false);
    this.roomId = getIntent().getStringExtra("Contact_ChatRoomId");
    this.MoA = getIntent().getStringExtra("Contact_RoomNickname");
    String str1 = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    Object localObject4 = Util.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
    Object localObject1 = Util.nullAsNil(getIntent().getStringExtra("Contact_Encryptusername"));
    if (str1.endsWith("@stranger")) {
      localObject1 = str1;
    }
    for (;;)
    {
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(str1);
      this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
      if (this.contact != null) {
        this.contact.adie = str1;
      }
      com.tencent.mm.plugin.profile.b.pFo.a(this.contact);
      Object localObject5 = getIntent().getStringExtra("Contact_Nick");
      int j = getIntent().getIntExtra("Contact_Sex", 0);
      String str4 = getIntent().getStringExtra("Contact_Province");
      Object localObject6 = getIntent().getStringExtra("Contact_City");
      String str5 = getIntent().getStringExtra("Contact_Signature");
      int m = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
      String str6 = getIntent().getStringExtra("Contact_VUser_Info");
      String str2 = getIntent().getStringExtra("Contact_Distance");
      int n = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
      String str7 = getIntent().getStringExtra("Contact_KWeibo");
      String str8 = getIntent().getStringExtra("Contact_KWeiboNick");
      String str3 = getIntent().getStringExtra("Contact_KFacebookName");
      long l = getIntent().getLongExtra("Contact_KFacebookId", 0L);
      this.MVy = getIntent().getStringExtra("Contact_BrandIconURL");
      String str9 = getIntent().getStringExtra("Contact_RegionCode");
      this.MVv = getIntent().getByteArrayExtra("Contact_customInfo");
      int i1 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
      boolean bool2 = getIntent().getBooleanExtra("force_get_contact", false);
      Log.i("MicroMsg.ContactInfoUI", "dkverify forceGetContact:%s  user:%s  roomid:%s, addContactScene: %d", new Object[] { Boolean.valueOf(bool2), str1, this.roomId, Integer.valueOf(this.pUt) });
      Object localObject2;
      Object localObject7;
      label786:
      label806:
      int k;
      int i;
      label1316:
      label1373:
      boolean bool1;
      if (bool2)
      {
        Log.d("MicroMsg.ContactInfoUI", "initView, forceGetContact, user = ".concat(String.valueOf(str1)));
        if ((this.contact != null) && (com.tencent.mm.contact.d.rs(this.contact.field_type))) {
          az.a.okP.aZ(str1, this.roomId);
        }
      }
      else
      {
        if (((this.contact == null) || ((int)this.contact.maN == 0)) && (au.bwO(str1)) && (this.pUt != 15))
        {
          localObject3 = Util.nullAsNil(getIntent().getStringExtra(f.e.adwe));
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3)) {
            localObject2 = this.pPi;
          }
          com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.openim.model.j(str1, Util.nullAsNil(this.roomId), (String)localObject2), 0);
        }
        if ((this.contact != null) && ((int)this.contact.maN > 0) && ((!ab.IW(this.contact.field_username)) || ((au.bwN(this.contact.field_username)) && (!au.bxa(this.contact.field_username)))))
        {
          if ((!this.contact.iZI()) || (!au.bwO(this.contact.field_username))) {
            break label2043;
          }
          localObject3 = Util.nullAsNil(getIntent().getStringExtra(f.e.adwe));
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3)) {
            localObject2 = this.pPi;
          }
          localObject7 = com.tencent.mm.kernel.h.baD().mCm;
          String str10 = this.contact.field_username;
          if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
            break label2031;
          }
          localObject3 = "";
          ((s)localObject7).a(new com.tencent.mm.openim.model.j(str10, (String)localObject3, (String)localObject2), 0);
        }
        getIntent().getIntExtra("Contact_verify_Scene", 9);
        getIntent().getIntExtra("key_add_contact_match_type", 0);
        localObject2 = getIntent().getStringExtra("key_add_contact_openim_appid");
        k = getIntent().getIntExtra("key_add_contact_custom_detail_visible", 0);
        localObject3 = getIntent().getStringExtra("key_add_contact_custom_detail");
        getIntent().getStringExtra("key_add_contact_desc_wording_id");
        getIntent().getStringExtra("key_add_contact_desc_icon");
        if ((this.contact != null) && ((int)this.contact.maN != 0) && (Util.nullAsNil(this.contact.field_username).length() > 0)) {
          break label2392;
        }
        this.contact = new au();
        this.contact.setUsername(str1);
        this.contact.AV((String)localObject4);
        this.contact.setNickname((String)localObject5);
        this.contact.AY(getIntent().getStringExtra("Contact_PyInitial"));
        this.contact.AZ(getIntent().getStringExtra("Contact_QuanPin"));
        this.contact.pv(j);
        this.contact.Bp(str4);
        this.contact.Bq((String)localObject6);
        this.contact.Bo(str5);
        this.contact.pr(m);
        this.contact.Bt(str6);
        this.contact.Br(str2);
        this.contact.Bs(str7);
        this.contact.pq(n);
        this.contact.Ba(str8);
        this.contact.gO(l);
        this.contact.Bj(str3);
        this.contact.Bu(str9);
        this.contact.pD(i1);
        if ((!Util.isNullOrNil(this.MVx)) && (this.pUt == 15))
        {
          bh.bCz();
          localObject4 = com.tencent.mm.model.c.bzB().aMi(str1);
          localObject5 = new cr(str1);
          ((cr)localObject5).field_conRemark = ((cr)localObject4).field_conRemark;
          ((cr)localObject5).field_conDescription = ((cr)localObject4).field_conDescription;
          ((cr)localObject5).field_contactLabels = ((cr)localObject4).field_contactLabels;
          ((cr)localObject5).field_conPhone = this.MVx;
          bh.bCz();
          com.tencent.mm.model.c.bzB().replace((IAutoDBItem)localObject5);
          this.MVx = null;
        }
        this.contact.BD((String)localObject3);
        this.contact.pE(k);
        this.contact.Bg((String)localObject2);
        if ((au.bwO(this.contact.field_username)) && ((this.pUt == 30) || (this.pUt == 45) || (this.pUt == 17)))
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
          localObject3 = this.contact.field_openImAppid;
          if (this.pUt != 17) {
            break label3011;
          }
          i = 2;
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(15320, new Object[] { localObject3, Integer.valueOf(i) });
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          this.contact.Bd((String)localObject1);
        }
        if (this.contact != null) {
          break label3016;
        }
        Log.e("MicroMsg.ContactInfoUI", "contact = null");
        getIntent().putExtra("Contact_User", this.contact.field_username);
        if ((!bool2) && ((int)this.contact.maN <= 0) && (this.contact.iZC()) && ((this.pUt == 17) || (this.pUt == 41)))
        {
          Log.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[] { this.contact.field_username });
          az.a.okP.aZ(this.contact.field_username, "");
          com.tencent.mm.modelavatar.d.LA(this.contact.field_username);
        }
        if (this.contact.kal != null) {
          break label3126;
        }
        bool1 = true;
        label1498:
        if (this.contact.kal != null) {
          break label3132;
        }
        i = 0;
        label1510:
        if (this.contact.kal != null) {
          break label3146;
        }
      }
      label2181:
      label3011:
      label3016:
      label3146:
      for (localObject1 = "";; localObject1 = Util.secPrint(this.contact.kal))
      {
        Log.i("MicroMsg.ContactInfoUI", "contact.getRemarkDesc() (%s, %s, %s)", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), localObject1 });
        if ((!bool2) && ((int)this.contact.maN <= 0) && (this.pUt == 96))
        {
          Log.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[] { this.contact.field_username });
          az.a.okP.j(this.contact.field_username, 1, getIntent().getStringExtra("key_add_contact_verify_ticket"));
          com.tencent.mm.modelavatar.d.aS(this.contact.field_username, 3);
        }
        if (this.contact.field_username.equals(z.bAM()))
        {
          bh.bCz();
          l = Util.getLong((String)com.tencent.mm.model.c.ban().d(65825, null), 0L);
          if (l > 0L)
          {
            this.contact.gO(l);
            localObject1 = this.contact;
            bh.bCz();
            ((au)localObject1).Bj((String)com.tencent.mm.model.c.ban().d(65826, null));
          }
          localObject1 = this.contact;
          bh.bCz();
          ((au)localObject1).Bx((String)com.tencent.mm.model.c.ban().d(286721, null));
          localObject1 = this.contact;
          bh.bCz();
          ((au)localObject1).By((String)com.tencent.mm.model.c.ban().d(286722, null));
          localObject1 = this.contact;
          bh.bCz();
          ((au)localObject1).Bz((String)com.tencent.mm.model.c.ban().d(286723, null));
        }
        if ((this.contact.field_username != null) && (this.contact.field_username.equals(au.bxd(z.bAM()))))
        {
          localObject1 = cb.bDe();
          localObject2 = Util.nullAsNil(((cb)localObject1).getProvince());
          localObject3 = Util.nullAsNil(((cb)localObject1).getCity());
          if (!Util.isNullOrNil((String)localObject2)) {
            this.contact.Bp((String)localObject2);
          }
          if (!Util.isNullOrNil((String)localObject3)) {
            this.contact.Bq((String)localObject3);
          }
          if (!Util.isNullOrNil(((cb)localObject1).countryCode)) {
            this.contact.Bu(RegionCodeDecoder.bI(((cb)localObject1).countryCode, ((cb)localObject1).provinceCode, ((cb)localObject1).cityCode));
          }
          i = Util.nullAs(Integer.valueOf(((cb)localObject1).sex), 0);
          localObject1 = Util.nullAsNil(((cb)localObject1).signature);
          this.contact.pv(i);
          this.contact.Bo((String)localObject1);
        }
        if (!Util.isNullOrNil(this.contact.field_username)) {
          break label3161;
        }
        Log.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[] { str1 });
        finish();
        AppMethodBeat.o(26996);
        return;
        az.a.okP.aZ(str1, "");
        break;
        label2031:
        localObject3 = Util.nullAsNil(this.roomId);
        break label786;
        label2043:
        if (au.bwQ(this.contact.field_username))
        {
          if (!((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).V(this.contact)) {
            break label806;
          }
          Log.d("MicroMsg.ContactInfoUI", "alvinluo updateOpenImKefuContact username: %s", new Object[] { this.contact.field_username });
          localObject2 = new com.tencent.mm.openim.api.i(7, this.contact.field_username, null);
          ((com.tencent.mm.openim.api.i)localObject2).prl = false;
          ((com.tencent.mm.openim.api.i)localObject2).prn = false;
          ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).b((com.tencent.mm.openim.api.i)localObject2, null);
          break label806;
        }
        localObject2 = com.tencent.mm.an.g.hU(this.contact.field_username);
        if ((this.contact.iZC()) && (com.tencent.mm.an.a.bGz()))
        {
          i = 1;
          if ((localObject2 != null) && ((!((com.tencent.mm.api.c)localObject2).aAJ()) || (i != 0))) {
            break label2288;
          }
          Log.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[] { Integer.valueOf(m) });
          localObject3 = az.a.okP;
          localObject7 = this.contact.field_username;
          if (!com.tencent.mm.contact.d.rs(this.contact.field_type)) {
            break label2279;
          }
        }
        label2279:
        for (localObject2 = "";; localObject2 = this.roomId)
        {
          ((az.b)localObject3).aZ((String)localObject7, (String)localObject2);
          com.tencent.mm.modelavatar.d.LA(this.contact.field_username);
          break;
          i = 0;
          break label2181;
        }
        label2288:
        if ((!this.contact.iZI()) || (i != 0)) {
          break label806;
        }
        Log.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(this.contact.kak) });
        localObject3 = az.a.okP;
        localObject7 = this.contact.field_username;
        if (com.tencent.mm.contact.d.rs(this.contact.field_type)) {}
        for (localObject2 = "";; localObject2 = this.roomId)
        {
          ((az.b)localObject3).aZ((String)localObject7, (String)localObject2);
          com.tencent.mm.modelavatar.d.LA(this.contact.field_username);
          break;
        }
        label2392:
        if (this.contact.sex == 0) {
          this.contact.pv(j);
        }
        if ((str4 != null) && (!str4.equals(""))) {
          this.contact.Bp(str4);
        }
        if ((localObject6 != null) && (!((String)localObject6).equals(""))) {
          this.contact.Bq((String)localObject6);
        }
        if ((str9 != null) && (!str9.equals(""))) {
          this.contact.Bu(str9);
        }
        if ((Util.isNullOrNil(this.contact.signature)) && (str5 != null) && (!str5.equals(""))) {
          this.contact.Bo(str5);
        }
        if (m != 0) {
          this.contact.pr(m);
        }
        if ((Util.isNullOrNil(this.contact.verifyInfo)) && (str6 != null) && (!str6.equals(""))) {
          this.contact.Bt(str6);
        }
        if ((Util.isNullOrNil(this.contact.field_nickname)) && (localObject5 != null) && (!((String)localObject5).equals(""))) {
          this.contact.setNickname((String)localObject5);
        }
        Log.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[] { Util.nullAsNil(this.MVx) });
        if ((!Util.isNullOrNil(this.MVx)) && (this.pUt == 15))
        {
          j = 1;
          str4 = this.contact.kar;
          i = j;
          if (str4 != null)
          {
            localObject6 = com.tencent.mm.contact.a.f(this.contact);
            i = j;
            if (localObject6 != null)
            {
              m = localObject6.length;
              j = 0;
            }
          }
        }
        for (;;)
        {
          i = 1;
          if (j < m)
          {
            if (localObject6[j].equals(this.MVx)) {
              i = 0;
            }
          }
          else
          {
            if (i != 0)
            {
              this.contact.BB(str4 + this.MVx + com.tencent.mm.contact.a.e(this.contact));
              this.MVx = null;
            }
            Log.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[] { Util.nullAsNil(this.contact.kar) });
            this.contact.setSource(15);
            this.contact.Br(str2);
            this.contact.gO(l);
            this.contact.Bj(str3);
            if (!com.tencent.mm.contact.d.rs(this.contact.field_type))
            {
              if (!Util.isNullOrNil((String)localObject4)) {
                this.contact.AV((String)localObject4);
              }
              if (!Util.isNullOrNil((String)localObject5)) {
                this.contact.setNickname((String)localObject5);
              }
              localObject4 = getIntent().getStringExtra("Contact_PyInitial");
              if (!Util.isNullOrNil((String)localObject4)) {
                this.contact.AY((String)localObject4);
              }
              localObject4 = getIntent().getStringExtra("Contact_QuanPin");
              if (!Util.isNullOrNil((String)localObject4)) {
                this.contact.AZ((String)localObject4);
              }
            }
            if ((!com.tencent.mm.contact.d.rs(this.contact.field_type)) && (!Util.isNullOrNil((String)localObject3))) {
              this.contact.BD((String)localObject3);
            }
            if ((!com.tencent.mm.contact.d.rs(this.contact.field_type)) && (k != 0)) {
              this.contact.pE(k);
            }
            if (Util.isNullOrNil((String)localObject2)) {
              break;
            }
            this.contact.Bg((String)localObject2);
            break;
          }
          j += 1;
        }
        i = 1;
        break label1316;
        if (!Util.isNullOrNil((String)localObject1))
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzB().aMi((String)localObject1);
          if ((localObject1 != null) && (!Util.isNullOrNil(((cr)localObject1).field_encryptUsername)))
          {
            this.contact.AW(((cr)localObject1).field_conRemark);
            break label1373;
          }
        }
        if (Util.isNullOrNil(str1)) {
          break label1373;
        }
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzB().aMi(str1);
        if ((localObject1 == null) || (Util.isNullOrNil(((cr)localObject1).field_encryptUsername))) {
          break label1373;
        }
        this.contact.AW(((cr)localObject1).field_conRemark);
        break label1373;
        bool1 = false;
        break label1498;
        i = this.contact.kal.length();
        break label1510;
      }
      label3126:
      label3132:
      label3161:
      setMMTitle("");
      com.tencent.mm.plugin.profile.d.al(this.contact);
      com.tencent.mm.plugin.profile.d.b(getIntent(), 1, 1, this.contact.field_username);
      Object localObject3 = this.MVy;
      if (au.bxf(this.contact.field_username))
      {
        this.MVr = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).kF(this);
        localObject1 = new tx();
        ((tx)localObject1).jvV = 2L;
        ((tx)localObject1).bMH();
        if (this.MVr != null)
        {
          this.MVr.a(this.screen, this.contact, this.MVt, this.pUt);
          localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.contact.field_username);
          localObject1 = "";
          if (localObject2 != null) {
            localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.model.a)localObject2).bWN()).replace(" ", "");
          }
          if ((!this.MVM) && (com.tencent.mm.contact.d.rs(this.contact.field_type)) && ((this.MVr instanceof m)))
          {
            j = com.tencent.mm.contact.a.g(this.contact);
            if (!Util.isNullOrNil((String)localObject1)) {
              break label5010;
            }
            i = 0;
            label3374:
            j = i + j;
            localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
            localObject3 = this.contact.field_username;
            if (!Util.isNullOrNil((String)localObject1)) {
              break label5015;
            }
            i = 0;
            label3402:
            if (j < 5) {
              break label5020;
            }
            j = 5;
          }
        }
      }
      label4865:
      label5010:
      label5015:
      label5020:
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).b(12040, new Object[] { localObject3, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j) });
        this.MVM = true;
        if ((!(this.MVr instanceof m)) && (!(this.MVr instanceof d)) && (!(this.MVr instanceof ContactWidgetTabBizInfo)))
        {
          bh.bCz();
          localObject1 = (String)com.tencent.mm.model.c.ban().get(at.a.acRG, "");
          if (((String)localObject1).contains(this.contact.field_username))
          {
            localObject1 = ((String)localObject1).replaceAll(this.contact.field_username + ",*", "");
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acRG, localObject1);
            Log.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[] { this.contact.field_username, localObject1 });
            if (Util.isNullOrNil((String)localObject1)) {
              com.tencent.mm.aa.c.aYo().R(262158, false);
            }
          }
        }
        if (this.screen != null)
        {
          this.MVs = ((NormalProfileHeaderPreference)this.screen.bAi("contact_profile_header_normal"));
          if (this.MVs != null)
          {
            this.MVs.b(this.MVC, this.MVL.getHeight(), this.MVD);
            localObject1 = this.MVs.getRootView();
            if ((localObject1 != null) && (((View)localObject1).getMeasuredHeight() != 0)) {
              afH(((View)localObject1).getMeasuredHeight());
            }
            localObject1 = this.MVs;
            ((NormalProfileHeaderPreference)localObject1).MYo = this.MVR;
            localObject2 = ((NormalProfileHeaderPreference)localObject1).getRootView();
            if ((localObject2 != null) && (((NormalProfileHeaderPreference)localObject1).MYo != null)) {
              ((View)localObject2).addOnLayoutChangeListener(((NormalProfileHeaderPreference)localObject1).MYo);
            }
          }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(305486);
            if (((au.bwf(ContactInfoUI.j(ContactInfoUI.this).field_username)) && (!z.bBr())) || ((au.bvX(ContactInfoUI.j(ContactInfoUI.this).field_username)) && (!z.bBn())) || ((au.bvZ(ContactInfoUI.j(ContactInfoUI.this).field_username)) && (!z.bBx())) || ((au.bvS(ContactInfoUI.j(ContactInfoUI.this).field_username)) && (!z.bBB())))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.plugin.profile.b.pFn.n(paramAnonymousMenuItem, ContactInfoUI.this);
            }
            ContactInfoUI.this.finish();
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(ContactInfoUI.j(ContactInfoUI.this).field_username, 1501, ContactInfoUI.n(ContactInfoUI.this), ContactInfoUI.o(ContactInfoUI.this), ContactInfoUI.this.getIntent());
            AppMethodBeat.o(305486);
            return true;
          }
        });
        com.tencent.mm.modelavatar.q.bFG().LC(this.contact.field_username);
        if (((!au.bwf(this.contact.field_username)) || (!z.bBr())) && ((!au.bvX(this.contact.field_username)) || (!z.bBn())) && ((!au.bvZ(this.contact.field_username)) || (!z.bBx())) && ((!au.bvS(this.contact.field_username)) || (!z.bBB()))) {
          break label5023;
        }
        this.MVw = true;
        AppMethodBeat.o(26996);
        return;
        if (au.bxg(this.contact.field_username))
        {
          this.MVr = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).kI(this);
          break;
        }
        if (au.bxh(this.contact.field_username))
        {
          this.MVr = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).kG(this);
          break;
        }
        if (au.bxi(this.contact.field_username))
        {
          this.MVr = ((com.tencent.mm.plugin.wxpaysdk.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wxpaysdk.api.c.class)).kH(this);
          break;
        }
        if ((1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztC, 1)) && (ab.IM(this.contact.field_username)))
        {
          this.MVr = new l(this);
          break;
        }
        if (au.bxe(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "sport");
          break;
        }
        if (au.bvS(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "qqmail");
          break;
        }
        if (au.bvT(this.contact.field_username))
        {
          this.MVr = new f(this);
          break;
        }
        if (au.bvV(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "tmessage");
          break;
        }
        if (au.bwh(this.contact.field_username))
        {
          this.MVr = new com.tencent.mm.plugin.topstory.ui.widget.a(this);
          break;
        }
        if (ab.IQ(this.contact.field_username))
        {
          this.MVr = new i(this);
          break;
        }
        if (au.bwb(this.contact.field_username))
        {
          this.MVr = new o(this);
          break;
        }
        if (au.bwS(this.contact.field_username))
        {
          this.MVr = new e(this);
          break;
        }
        if (au.bwd(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "nearby");
          break;
        }
        if (au.bwe(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "shake");
          break;
        }
        if (au.bwf(this.contact.field_username))
        {
          this.MVr = new k(this);
          break;
        }
        if (au.bwg(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.aj(this, "readerapp", "widget_type_news");
          break;
        }
        if (au.bwo(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.aj(this, "readerapp", "widget_type_weibo");
          break;
        }
        if (au.bvY(this.contact.field_username))
        {
          this.MVr = new g(this);
          break;
        }
        if (au.bvZ(this.contact.field_username))
        {
          this.MVr = com.tencent.mm.br.c.al(this, "masssend");
          break;
        }
        if (au.bwa(this.contact.field_username))
        {
          this.MVr = new h(this);
          break;
        }
        label4898:
        if ((this.contact.iZC()) || (getIntent().getBooleanExtra("key_use_new_contact_profile", false)))
        {
          for (localObject1 = null;; localObject1 = localObject2)
          {
            try
            {
              localObject2 = this.MVv;
              if (localObject2 != null) {
                break label4672;
              }
              localObject1 = null;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                label4672:
                Log.printErrStackTrace("MicroMsg.ContactInfoUI", localIOException, "", new Object[0]);
                continue;
                if (com.tencent.mm.an.g.My(localIOException))
                {
                  bool1 = true;
                }
                else
                {
                  if (localObject1 != null)
                  {
                    com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
                    localc.field_extInfo = ((ahl)localObject1).pSu;
                    localc.field_type = localc.dO(false).getServiceType();
                    if (localc.aAN())
                    {
                      bool1 = true;
                      continue;
                    }
                    if (localc.aAM())
                    {
                      bool1 = true;
                      continue;
                    }
                  }
                  if (getIntent().getBooleanExtra("key_use_new_contact_profile", false)) {
                    bool1 = true;
                  } else if ((!com.tencent.mm.an.g.MB(this.contact.field_username)) && (!com.tencent.mm.an.g.MA(this.contact.field_username)) && (this.contact.iZC())) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                }
              }
              localObject1 = new d(this, (String)localObject3, (ahl)localObject1);
              if (Util.isNullOrNil(this.pPi)) {
                break label4898;
              }
              ((d)localObject1).pPi = this.pPi;
              this.MVr = ((com.tencent.mm.pluginsdk.c.a)localObject1);
            }
            localObject2 = this.contact.field_username;
            if ((!MMApplicationContext.getDefaultPreference().getBoolean("use_new_profile", true)) || (ab.Jd((String)localObject2)) || (au.bwc((String)localObject2)) || (au.bwn((String)localObject2))) {
              break label4859;
            }
            if (!com.tencent.mm.an.g.Mw((String)localObject2)) {
              break label4717;
            }
            bool1 = true;
            Log.i("MicroMsg.ContactInfoUI", "username:%s, isUseNewProfileUI:%b", new Object[] { this.contact.field_username, Boolean.valueOf(bool1) });
            if (!bool1) {
              break label4865;
            }
            if (this.MVN == null) {
              this.MVN = new ContactWidgetTabBizInfo(this, (String)localObject3, (ahl)localObject1, this.AxK);
            }
            this.MVN.MVy = ((String)localObject3);
            this.MVN.MWY = ((ahl)localObject1);
            this.MVN.enterTime = this.AxK;
            this.MVN.pPi = this.pPi;
            this.MVr = this.MVN;
            break;
            localObject2 = (ahl)new ahl().parseFrom(this.MVv);
          }
          label4717:
          label4859:
          break;
        }
        if (au.bwk(this.contact.field_username))
        {
          this.MVr = new p(this);
          break;
        }
        if (au.bwl(this.contact.field_username))
        {
          this.MVr = new j(this);
          break;
        }
        if (ab.IP(this.contact.field_username))
        {
          this.MVr = new com.tencent.mm.plugin.downloader_app.d.a(this);
          break;
        }
        this.MVr = new com.tencent.mm.plugin.profile.a(this);
        gBr();
        break;
        i = 1;
        break label3374;
        i = 1;
        break label3402;
      }
      label5023:
      this.MVw = false;
      AppMethodBeat.o(26996);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26997);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
    }
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("_delete_ok_", false)))
    {
      setResult(-1, getIntent().putExtra("_delete_ok_", true));
      finish();
      AppMethodBeat.o(26997);
      return;
    }
    if (this.MVr != null) {
      this.MVr.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(26997);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(27005);
    if (((this.storyGallery == null) || (!this.storyGallery.onBackPressed())) && (!getSupportFragmentManager().isDestroyed())) {
      super.onBackPressed();
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 1501, this.pUt, this.AxK, getIntent());
    AppMethodBeat.o(27005);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(26988);
    super.onConfigurationChanged(paramConfiguration);
    if (!com.tencent.mm.plugin.textstatus.a.a.kj(this)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nKe = bool;
      if ((this.MVz != null) && (!this.MVz.isVisible)) {
        this.MVz.jIr();
      }
      if ((!(this.MVr instanceof ContactWidgetTabBizInfo)) && ((this.contact == null) || (!au.bwQ(this.contact.field_username))) && (this.MVD))
      {
        paramConfiguration = (RelativeLayout)findViewById(R.h.mm_preference_list_content_root);
        if (paramConfiguration != null)
        {
          if (this.MVH != null)
          {
            paramConfiguration.removeView(this.MVQ);
            paramConfiguration.removeView(this.MVH.getView());
            this.MVH.hFv();
            this.MVH = null;
          }
          this.MVA = false;
          gBr();
        }
      }
      gBt();
      paramConfiguration = gBi();
      if (paramConfiguration != null) {
        paramConfiguration.Ds(getIntent().getStringExtra("Contact_User"));
      }
      AppMethodBeat.o(26988);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26986);
    this.MVE = ac.hFS();
    if ((this.MVE) && (((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(getIntent().getStringExtra("Contact_User"))))
    {
      bool = true;
      this.MVD = bool;
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(Util.nullAsNil(getIntent().getStringExtra("Contact_User")));
      if (localau == null) {
        break label299;
      }
      com.tencent.mm.kernel.h.baF();
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(localau.field_username)) {
        break label299;
      }
      this.MVC = true;
      label114:
      if (this.MVE) {
        this.MVC = false;
      }
      if ((this.MVC) || (this.MVD)) {
        customfixStatusbar(true);
      }
      super.onCreate(paramBundle);
      MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
      if (com.tencent.mm.plugin.textstatus.a.a.kj(this)) {
        break label307;
      }
    }
    label299:
    label307:
    for (boolean bool = true;; bool = false)
    {
      this.nKe = bool;
      this.AxK = System.currentTimeMillis();
      this.Inv = findViewById(R.h.action_bar_container);
      this.MVL = this.Inv.findViewById(R.h.action_bar_root);
      gBt();
      paramBundle = getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
      Log.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(bh.baz()) });
      this.MVx = getIntent().getStringExtra("Contact_Search_Mobile");
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        break label312;
      }
      finish();
      AppMethodBeat.o(26986);
      return;
      bool = false;
      break;
      this.MVC = false;
      break label114;
    }
    label312:
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
    bh.bCz();
    com.tencent.mm.model.c.bzB().a(this);
    bh.bCz();
    com.tencent.mm.model.c.bzC().a(this);
    initView();
    hideActionbarLine();
    if ((this.MVr instanceof com.tencent.mm.pluginsdk.c.b)) {
      ((com.tencent.mm.pluginsdk.c.b)this.MVr).onCreate();
    }
    paramBundle = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkC = com.tencent.mm.plugin.profile.d.bo(getIntent());
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(273, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    AppMethodBeat.o(26986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26989);
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", false);
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.hxW().jkC = 0L;
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
      bh.bCz();
      com.tencent.mm.model.c.bzB().b(this);
      bh.bCz();
      com.tencent.mm.model.c.bzC().b(this);
    }
    if (this.MVr == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactInfoUI", "onDestroy bodyWidget is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (this.MVr != null) {
        this.MVr.dvq();
      }
      if ((this.MVr instanceof com.tencent.mm.pluginsdk.c.b)) {
        ((com.tencent.mm.pluginsdk.c.b)this.MVr).aXx();
      }
      if (com.tencent.mm.plugin.sns.c.q.Qkh != null) {
        com.tencent.mm.plugin.sns.c.q.Qkh.bq(this);
      }
      super.onDestroy();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(273, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(291, this);
      if (this.storyGallery != null) {
        this.storyGallery.onDestroy();
      }
      com.tencent.mm.plugin.profile.d.b(getIntent(), 18, 1, this.contact.field_username);
      com.tencent.mm.plugin.report.service.h.OAn.b(17283, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.bo(getIntent())), this.contact.field_username, Boolean.valueOf(this.MVC), Boolean.valueOf(this.MVF), Integer.valueOf(this.contact.uin), Integer.valueOf(this.MVG) });
      if (this.MVH != null) {
        this.MVH.hFv();
      }
      AppMethodBeat.o(26989);
      return;
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26999);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(26999);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(26999);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(27000);
    new MMHandler().post(new b(this, paramString));
    AppMethodBeat.o(27000);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26993);
    com.tencent.mm.modelstat.d.d(4, "ContactInfoUI" + getIdentString(), hashCode());
    af.bHf().remove(this);
    super.onPause();
    bh.baH().postAtFrontOfQueueToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305491);
        bh.bCz();
        com.tencent.mm.model.c.ban().iZy();
        AppMethodBeat.o(305491);
      }
    });
    if (getIntent().getBooleanExtra("key_from_wesport_right_newtips", false))
    {
      com.tencent.mm.plugin.newtips.a.gtf();
      com.tencent.mm.plugin.newtips.a.i.aP(com.tencent.mm.plugin.newtips.a.d.Msg, getActivityBrowseTimeMs());
    }
    for (;;)
    {
      gBq();
      if (this.MVz != null) {
        this.MVz.jIr();
      }
      if (this.storyGallery != null) {
        this.storyGallery.onPause();
      }
      if (((this.MVr instanceof d)) || ((this.MVr instanceof ContactWidgetTabBizInfo))) {
        this.MVr.dvq();
      }
      if ((this.MVr instanceof com.tencent.mm.pluginsdk.c.b)) {
        ((com.tencent.mm.pluginsdk.c.b)this.MVr).onPause();
      }
      com.tencent.mm.pluginsdk.ui.span.p.b(this.vIA);
      if (this.MVH != null) {
        this.MVH.hFx();
      }
      AppMethodBeat.o(26993);
      return;
      if (getIntent().getBooleanExtra("key_from_wesport_plugin_newtips", false))
      {
        com.tencent.mm.plugin.newtips.a.gtf();
        com.tencent.mm.plugin.newtips.a.i.aP(com.tencent.mm.plugin.newtips.a.d.Mse, getActivityBrowseTimeMs());
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26998);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactInfoUI", paramf + " item has been clicked!");
    if (this.MVr != null) {
      this.MVr.anl(paramf);
    }
    if (paramPreference != null)
    {
      if (!paramPreference.mKey.equals("contact_info_sns")) {
        break label107;
      }
      com.tencent.mm.plugin.profile.d.b(getIntent(), 3, 1, this.contact.field_username);
    }
    for (;;)
    {
      if ((paramPreference instanceof NormalProfileHeaderPreference)) {
        gBs();
      }
      AppMethodBeat.o(26998);
      return false;
      label107:
      if (paramPreference.mKey.equals("contact_info_more")) {
        com.tencent.mm.plugin.profile.d.b(getIntent(), 6, 1, this.contact.field_username);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(27002);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(27002);
      return;
    }
    Log.i("MicroMsg.ContactInfoUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27002);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.bAi("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.gBU();
        }
        AppMethodBeat.o(27002);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this, getString(paramInt), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(26976);
              paramAnonymousDialogInterface.dismiss();
              com.tencent.mm.pluginsdk.permission.b.lx(ContactInfoUI.this.getContext());
              AppMethodBeat.o(26976);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(305471);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(305471);
            }
          });
        }
        AppMethodBeat.o(27002);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = (NormalUserFooterPreference)this.screen.bAi("contact_info_footer_normal");
        if (paramArrayOfString != null) {
          paramArrayOfString.gBT();
        }
        AppMethodBeat.o(27002);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(305583);
          com.tencent.mm.pluginsdk.permission.b.lx(ContactInfoUI.this.getContext());
          AppMethodBeat.o(305583);
        }
      }, null);
    }
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(26992);
    super.onRestart();
    this.MVM = false;
    AppMethodBeat.o(26992);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26990);
    com.tencent.mm.modelstat.d.d(3, "ContactInfoUI" + getIdentString(), hashCode());
    af.bHf().add(this);
    super.onResume();
    View localView = ((ViewGroup)getContentView()).getFocusedChild();
    if (localView != null)
    {
      localView.clearFocus();
      Log.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[] { Integer.valueOf(localView.getId()) });
    }
    this.MVz = ((PullDownListView)getListView());
    if (this.storyGallery != null) {
      this.storyGallery.onResume();
    }
    if (this.screen != null)
    {
      this.MVs = ((NormalProfileHeaderPreference)this.screen.bAi("contact_profile_header_normal"));
      if (this.MVs != null) {
        this.MVs.b(this.MVC, this.MVL.getHeight(), this.MVD);
      }
    }
    if (((this.MVr instanceof d)) || ((this.MVr instanceof ContactWidgetTabBizInfo))) {
      this.MVr.a(this.screen, this.contact, this.MVt, this.pUt);
    }
    if ((this.MVr instanceof com.tencent.mm.pluginsdk.c.b)) {
      ((com.tencent.mm.pluginsdk.c.b)this.MVr).onResume();
    }
    com.tencent.mm.pluginsdk.ui.span.p.a(this.vIA);
    if (this.MVH != null) {
      this.MVH.hFw();
    }
    AppMethodBeat.o(26990);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(27004);
    Log.d("MicroMsg.ContactInfoUI", "onSceneEnd errType[%s] errCode[%s] errMsg[%s] sceneType[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if ((273 == paramp.getType()) && (this.contact != null) && ((this.MVr instanceof com.tencent.mm.plugin.profile.a)) && (Util.isEqual(this.contact.field_username, ((com.tencent.mm.plugin.story.model.a.i)paramp).userName)))
    {
      int i = ((com.tencent.mm.plugin.story.model.a.i)paramp).source;
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      if (i == com.tencent.mm.plugin.story.h.a.hyX())
      {
        i = 1;
        if (i != 0) {
          if (((paramInt1 != 0) && (paramInt1 != 4)) || (paramInt2 == 315)) {
            break label177;
          }
        }
      }
      label177:
      for (boolean bool = true;; bool = false)
      {
        this.MVF = bool;
        this.MVG = ((com.tencent.mm.plugin.story.model.a.i)paramp).Hit;
        AppMethodBeat.o(27004);
        return;
        i = 0;
        break;
      }
    }
    if ((291 == paramp.getType()) && (this.contact != null)) {
      new MMHandler().post(new b(this, this.contact.field_username));
    }
    AppMethodBeat.o(27004);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(26991);
    super.onStart();
    if (this.storyGallery != null) {
      this.storyGallery.onStart();
    }
    AppMethodBeat.o(26991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(26994);
    super.onStop();
    if (this.storyGallery != null) {
      this.storyGallery.onStop();
    }
    AppMethodBeat.o(26994);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305681);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFF());
    paramHashSet.add(((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFG());
    AppMethodBeat.o(305681);
  }
  
  static abstract interface a<T>
  {
    public abstract Boolean apply(T paramT);
  }
  
  static final class b
    implements Runnable
  {
    private WeakReference<ContactInfoUI> eIW;
    private String luk;
    
    b(ContactInfoUI paramContactInfoUI, String paramString)
    {
      AppMethodBeat.i(26978);
      this.eIW = new WeakReference(paramContactInfoUI);
      this.luk = paramString;
      AppMethodBeat.o(26978);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26979);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.eIW.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.luk });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26979);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.p(localContactInfoUI)), ContactInfoUI.j(localContactInfoUI).field_username, this.luk });
      if ((ContactInfoUI.j(localContactInfoUI) != null) && (!Util.isNullOrNil(ContactInfoUI.j(localContactInfoUI).field_username)) && ((ContactInfoUI.j(localContactInfoUI).field_username.equals(this.luk)) || (ContactInfoUI.j(localContactInfoUI).field_username.equals(au.bxd(this.luk)))))
      {
        ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.luk));
        if (ContactInfoUI.q(localContactInfoUI) != null)
        {
          ContactInfoUI.q(localContactInfoUI).dvq();
          ContactInfoUI.r(localContactInfoUI);
          ContactInfoUI.h(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
        ContactInfoUI.s(localContactInfoUI);
      }
      AppMethodBeat.o(26979);
    }
  }
  
  static final class c
    implements Runnable
  {
    private bs MVW;
    private WeakReference<ContactInfoUI> eIW;
    
    c(ContactInfoUI paramContactInfoUI, bs parambs)
    {
      AppMethodBeat.i(305543);
      this.eIW = new WeakReference(paramContactInfoUI);
      this.MVW = parambs;
      AppMethodBeat.o(305543);
    }
    
    public final void run()
    {
      AppMethodBeat.i(305552);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.eIW.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange user: %s", new Object[] { this.MVW });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(305552);
        return;
      }
      String str2 = ContactInfoUI.j(localContactInfoUI).field_username;
      if (this.MVW != null) {}
      for (String str1 = this.MVW.field_encryptUsername;; str1 = "")
      {
        Log.i("MicroMsg.ContactInfoUI", "onNotifyFriendUserChange contact.user:%s, notify.user:%s, friendUser:%s", new Object[] { str2, str1, this.MVW.field_username });
        if ((ContactInfoUI.j(localContactInfoUI) != null) && (this.MVW != null) && (!Util.isNullOrNil(ContactInfoUI.j(localContactInfoUI).field_username)) && (ContactInfoUI.j(localContactInfoUI).field_username.equals(this.MVW.field_encryptUsername)) && (!ab.IW(ContactInfoUI.j(localContactInfoUI).field_username)))
        {
          str1 = this.MVW.field_username;
          if ((!Util.isNullOrNil(str1)) && (!str1.equals(ContactInfoUI.j(localContactInfoUI).field_username))) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1430, 4);
          }
          if (!Util.isNullOrNil(str1)) {
            ContactInfoUI.a(localContactInfoUI, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str1));
          }
          localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.j(localContactInfoUI).field_username);
          Log.i("MicroMsg.ContactInfoUI", "new contact user:%s", new Object[] { ContactInfoUI.j(localContactInfoUI).field_username });
          if (ContactInfoUI.q(localContactInfoUI) != null)
          {
            ContactInfoUI.q(localContactInfoUI).dvq();
            ContactInfoUI.h(localContactInfoUI).removeAll();
          }
          localContactInfoUI.initView();
        }
        AppMethodBeat.o(305552);
        return;
      }
    }
  }
  
  static final class d
    implements Runnable
  {
    private cr MVX;
    private WeakReference<ContactInfoUI> eIW;
    
    d(ContactInfoUI paramContactInfoUI, cr paramcr)
    {
      AppMethodBeat.i(26980);
      this.eIW = new WeakReference(paramContactInfoUI);
      this.MVX = paramcr;
      AppMethodBeat.o(26980);
    }
    
    public final void run()
    {
      AppMethodBeat.i(26981);
      ContactInfoUI localContactInfoUI = (ContactInfoUI)this.eIW.get();
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.MVX });
      if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
      {
        AppMethodBeat.o(26981);
        return;
      }
      Log.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.p(localContactInfoUI)), ContactInfoUI.j(localContactInfoUI).field_username, this.MVX });
      if ((ContactInfoUI.j(localContactInfoUI) != null) && (this.MVX != null) && (!Util.isNullOrNil(ContactInfoUI.j(localContactInfoUI).field_username)) && (ContactInfoUI.j(localContactInfoUI).field_username.equals(this.MVX.field_encryptUsername)) && (!ab.IW(ContactInfoUI.j(localContactInfoUI).field_username)))
      {
        ContactInfoUI.j(localContactInfoUI).AW(this.MVX.field_conRemark);
        localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.j(localContactInfoUI).field_username);
        if (ContactInfoUI.q(localContactInfoUI) != null)
        {
          ContactInfoUI.q(localContactInfoUI).dvq();
          ContactInfoUI.h(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(26981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI
 * JD-Core Version:    0.7.0.1
 */