package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.v;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean afdT = Boolean.TRUE;
  private final MTimerHandler aena;
  private View afdU;
  private MStorage.IOnStorageChange afdV;
  private boolean afdW;
  private Context context;
  private View hDw;
  private boolean isVisible;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.hDw = null;
    this.afdU = null;
    this.isVisible = true;
    this.aena = new MTimerHandler(new l.1(this), true);
    this.afdV = new l.2(this);
    this.afdW = false;
    this.context = paramContext;
    d.bNI().add(this.afdV);
    jyy();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bn parambn)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (a.mp(this.context))
    {
      this.hDw = af.mU(this.context).inflate(R.i.gkg, this);
      ((TextView)this.hDw.findViewById(R.h.fII)).setText(p.b(this.context, parambn.field_displayName));
      localTextView = (TextView)this.hDw.findViewById(R.h.fIH);
      localObject = d.bNH().aLv(parambn.field_talker);
      Context localContext = this.context;
      int i = ((bp)localObject).field_type;
      int j = parambn.field_addScene;
      String str = ((bp)localObject).field_msgContent;
      if (((bp)localObject).jbg()) {
        break label252;
      }
      bool = true;
      label142:
      localObject = b.a(localContext, i, j, str, bool);
      if (!Util.isNullOrNil((String)localObject)) {
        break label258;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.afdU = this.hDw.findViewById(R.h.fIu);
      this.hDw.setOnClickListener(new l.5(this));
      a.b.g((ImageView)((MaskLayout)this.hDw.findViewById(R.h.fIp)).getContentView(), parambn.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.hDw = af.mU(this.context).inflate(R.i.gkf, this);
      break;
      label252:
      bool = false;
      break label142;
      label258:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public static void gqT()
  {
    AppMethodBeat.i(37844);
    bh.bCz();
    if (c.ban().getInt(143618, 0) > 0) {
      ac.aZ("fmessage", 2);
    }
    bh.bCz();
    c.ban().B(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = d.bNI().jbc();
    int i = ((List)localObject).size();
    Log.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      jyx();
      localObject = this.hDw.findViewById(R.h.fIu);
      if (localObject != null) {
        if (!this.isVisible) {
          break label199;
        }
      }
    }
    label199:
    for (i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.afdU.setOnTouchListener(new l.3(this));
      i = d.bNI().jbe();
      Log.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.hDw.findViewById(R.h.fID);
      ((TextView)localObject).setBackgroundResource(v.nH(this.context));
      if (i > 0) {
        break label205;
      }
      ((TextView)localObject).setVisibility(8);
      afdT = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bn)((List)localObject).get(0));
        break;
      }
      nT((List)localObject);
      break;
    }
    label205:
    ((TextView)localObject).setVisibility(0);
    afdT = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(R.k.badge_count_more);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(v.bC(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  private void jyx()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.hDw = af.mU(this.context).inflate(R.i.gkd, this);
    this.afdU = this.hDw.findViewById(R.h.fIF);
    Object localObject = this.afdU.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.bs(this.context, R.f.ContactListHeight) * a.mo(this.context)));
    this.afdU.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.hDw.setOnClickListener(new l.4(this));
    localObject = (MaskLayout)this.hDw.findViewById(R.h.fIp);
    q.bFp();
    Bitmap localBitmap = AvatarStorage.LK("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void jyy()
  {
    AppMethodBeat.i(37843);
    int i = d.bNI().jbe();
    Log.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      bh.bCz();
      c.ban().B(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  private void nT(List<bn> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.hDw = View.inflate(this.context, R.i.gke, this);
    int i = paramList.size();
    Log.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bn)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.hDw.findViewById(R.h.fIp);
    a.b.g((ImageView)localMaskLayout.getContentView(), ((bn)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bn)paramList.get(1);
    localMaskLayout = (MaskLayout)this.hDw.findViewById(R.h.fIq);
    a.b.g((ImageView)localMaskLayout.getContentView(), ((bn)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bn)paramList.get(2);
      localMaskLayout = (MaskLayout)this.hDw.findViewById(R.h.fIr);
      a.b.g((ImageView)localMaskLayout.getContentView(), ((bn)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bn)paramList.get(3);
      localObject = (MaskLayout)this.hDw.findViewById(R.h.fIs);
      a.b.g((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.afdU = this.hDw.findViewById(R.h.fIu);
    this.afdU.setOnClickListener(new l.6(this));
    AppMethodBeat.o(37841);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(252848);
    if (bh.baz()) {
      d.bNI().remove(this.afdV);
    }
    AppMethodBeat.o(252848);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.afdW = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    Log.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.hDw.findViewById(R.h.fIu);
    if (localView != null) {
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.isVisible = paramBoolean;
      AppMethodBeat.o(37842);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */