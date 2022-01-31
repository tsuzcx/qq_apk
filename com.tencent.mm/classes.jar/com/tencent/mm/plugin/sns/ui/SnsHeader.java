package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader
  extends LinearLayout
{
  Context context;
  private String cpW;
  boolean ctJ;
  String dZZ;
  private Dialog dialog;
  SnsHeader.c rQC;
  private SnsHeader.a rQD;
  private SnsHeader.b rQE;
  private boolean rQF;
  private Map<Integer, View> rQG;
  private String rQH;
  Bitmap rQI;
  private String rnO;
  private int type;
  String userName;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38951);
    this.rQF = false;
    this.ctJ = false;
    this.rQG = new HashMap();
    this.rQH = "";
    this.rQI = null;
    init(paramContext);
    AppMethodBeat.o(38951);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38952);
    this.rQF = false;
    this.ctJ = false;
    this.rQG = new HashMap();
    this.rQH = "";
    this.rQI = null;
    init(paramContext);
    AppMethodBeat.o(38952);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(38957);
    this.context = paramContext;
    View localView = w.hM(paramContext).inflate(2130970829, this, true);
    this.rQC = new SnsHeader.c(this);
    this.rQC.jII = ((TextView)localView.findViewById(2131823254));
    this.rQC.ehv = ((ImageView)localView.findViewById(2131821210));
    this.rQC.rEI = ((TextView)localView.findViewById(2131828001));
    this.rQC.rQN = ((ImageView)localView.findViewById(2131827999));
    this.rQC.rQO = ((ImageView)localView.findViewById(2131828000));
    this.rQC.rQP = ((LinearLayout)localView.findViewById(2131828008));
    this.rQC.rQQ = ((LinearLayout)localView.findViewById(2131828004));
    this.rQC.rQR = ((SnsStoryHeaderView)localView.findViewById(2131828002));
    this.rQC.rQR.setSessionId(this.cpW);
    this.rQC.rQR.setEnterObjectId(this.rnO);
    this.rQC.rQN.setContentDescription(paramContext.getString(2131303780));
    this.rQC.rQN.setOnClickListener(new SnsHeader.1(this, paramContext));
    this.rQC.ehv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = 1;
        AppMethodBeat.i(38948);
        paramAnonymousView = ag.coT().arw(SnsHeader.e(SnsHeader.this));
        if ((paramAnonymousView != null) && ((com.tencent.mm.n.a.je(paramAnonymousView.field_type)) || (SnsHeader.f(SnsHeader.this))))
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
          if ((SnsHeader.e(SnsHeader.this) != null) && (SnsHeader.e(SnsHeader.this).length() > 0))
          {
            if (SnsHeader.c(SnsHeader.this) == 1) {
              i = 6;
            }
            paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.gmO.c(paramAnonymousView, paramContext);
          }
          AppMethodBeat.o(38948);
          return;
        }
        paramAnonymousView = ((Activity)paramContext).getIntent();
        paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
        com.tencent.mm.plugin.sns.c.a.gmO.c(paramAnonymousView, paramContext);
        AppMethodBeat.o(38948);
      }
    });
    AppMethodBeat.o(38957);
  }
  
  public final void cvh()
  {
    AppMethodBeat.i(38959);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.dZZ;
    }
    Object localObject1 = ag.getAccSnsPath();
    ab.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    l locall = ag.cpj().abz(str1);
    String str2 = locall.field_bgId;
    Object localObject3 = locall.field_older_bgId;
    ab.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = i.Zz(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = ao.gl((String)localObject1, str1);
    e.um(str4);
    int i;
    String str5;
    if ((locall.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        ab.d("MicroMsg.SnsHeader", "bg is change");
        ag.cpj().aby(str1);
        if (e.cN(ao.gl((String)localObject1, str1) + str6))
        {
          e.deleteFile(ao.gl((String)localObject1, str1) + str3);
          e.h(ao.gl((String)localObject1, str1), str6, str3);
        }
        locall.field_local_flag &= 0xFFFFFFFE;
        ag.cpj().c(locall);
      }
      if ((e.cN(ao.gl(ag.getAccSnsPath(), str2) + (String)localObject3)) && (!e.cN(ao.gl((String)localObject1, str1) + str6)))
      {
        e.C(ao.gl((String)localObject1, str2) + (String)localObject3, ao.gl((String)localObject1, str1) + str6);
        ab.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = locall.field_bgUrl;
      if (str2 == null) {
        break label770;
      }
      ag.cpc();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = g.a((String)localObject1, str5, str2, true, az.yNU);
      ab.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        e.deleteFile(str4 + str6);
      }
    }
    label683:
    Object localObject2;
    label770:
    for (localObject1 = localObject3;; localObject2 = null)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (str2 != null)
        {
          ag.cpc();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = g.a((String)localObject1, str5, str2, false, az.yNU);
        }
      }
      if (this.rQC.rQN != null)
      {
        this.rQC.rQN.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label683;
        }
        this.rQC.rQN.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.rQC.rQP.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.dZZ.equals(str1)))) {
          this.rQC.rQP.setVisibility(0);
        }
        this.rQF = locall.csw();
        AppMethodBeat.o(38959);
        return;
        i = 0;
        break;
        try
        {
          if ((this.rQI == null) || (this.rQI.isRecycled()))
          {
            ab.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.rQI = d.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.rQI);
          this.rQC.rQN.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean cvi()
  {
    AppMethodBeat.i(38960);
    if (this.rQC.rQQ == null)
    {
      AppMethodBeat.o(38960);
      return false;
    }
    Object localObject = ak.cpx();
    LinkedList localLinkedList = new LinkedList();
    final int i = 0;
    com.tencent.mm.plugin.sns.storage.n localn1;
    boolean bool;
    for (;;)
    {
      if (i >= ((List)localObject).size()) {
        break label114;
      }
      localn1 = (com.tencent.mm.plugin.sns.storage.n)((List)localObject).get(i);
      try
      {
        bool = ((bct)new bct().parseFrom(localn1.field_postBuf)).xsF;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localLinkedList.add(localn1);
        }
      }
      i += 1;
    }
    label114:
    localObject = "";
    i = 0;
    for (;;)
    {
      if (i >= localLinkedList.size()) {
        break label224;
      }
      localn1 = (com.tencent.mm.plugin.sns.storage.n)localLinkedList.get(i);
      try
      {
        bool = ((bct)new bct().parseFrom(localn1.field_postBuf)).xsF;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((com.tencent.mm.plugin.sns.storage.n)localLinkedList.get(i)).csH() + " ";
        }
      }
      i += 1;
    }
    label224:
    ab.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.rQH });
    if (((String)localObject).equals(this.rQH))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(38960);
        return true;
      }
      AppMethodBeat.o(38960);
      return false;
    }
    this.rQH = ((String)localObject);
    this.rQC.rQQ.removeAllViews();
    localObject = this.rQC.rQQ;
    label357:
    int j;
    final int k;
    label441:
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new SnsHeader.d(this));
      i = 0;
      if (i >= localLinkedList.size()) {
        break label611;
      }
      j = ((com.tencent.mm.plugin.sns.storage.n)localLinkedList.get(i)).rCV;
      k = localLinkedList.size();
      if ((!this.rQG.containsKey(Integer.valueOf(j))) || (this.rQG.get(Integer.valueOf(j)) == null)) {
        break label540;
      }
      localObject = (View)this.rQG.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((com.tencent.mm.plugin.sns.storage.n)localLinkedList.get(i)).csH());
      com.tencent.mm.plugin.sns.storage.n localn2 = (com.tencent.mm.plugin.sns.storage.n)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131824977);
      if (localn2.field_type != 15) {
        break label597;
      }
      localTextView.setText(2131303933);
    }
    for (;;)
    {
      this.rQC.rQQ.addView((View)localObject);
      i += 1;
      break label357;
      i = 8;
      break;
      label540:
      localObject = (LinearLayout)w.hM(this.context).inflate(2130969857, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38950);
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            ab.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = ag.cpf().abv((String)localObject2);
            if ((SnsHeader.h(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              Object localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.h(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.field_userName == null) || (paramAnonymousView.field_userName.equals("")))
              {
                ab.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                AppMethodBeat.o(38950);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.field_userName);
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = b.lV(726);
              ((b)localObject2).lY(k).lY(i).lY(paramAnonymousView.field_createTime);
              ((b)localObject2).ake();
              SnsHeader.h(SnsHeader.this).startActivity((Intent)localObject1);
              try
              {
                localObject1 = (bct)new bct().parseFrom(paramAnonymousView.field_postBuf);
                if ((((bct)localObject1).xsx == 201) || (((bct)localObject1).xsx == 210) || (((bct)localObject1).xsx != 211))
                {
                  ((bct)localObject1).xsF = true;
                  paramAnonymousView.field_postBuf = ((bct)localObject1).toByteArray();
                  ag.cpf().b(paramAnonymousView.rCV, paramAnonymousView);
                }
                AppMethodBeat.o(38950);
                return;
              }
              catch (Exception paramAnonymousView) {}
            }
          }
          AppMethodBeat.o(38950);
        }
      });
      this.rQG.put(Integer.valueOf(j), localObject);
      break label441;
      label597:
      localTextView.setTag(Integer.valueOf(2131303928));
    }
    label611:
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(38960);
      return true;
    }
    AppMethodBeat.o(38960);
    return false;
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(38958);
    if ((this.rQC != null) && (this.rQC.ehv != null)) {
      this.rQC.ehv.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(38958);
  }
  
  public void setBackClickListener(SnsHeader.a parama)
  {
    this.rQD = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(38956);
    this.rnO = paramString;
    if ((this.rQC != null) && (this.rQC.rQR != null)) {
      this.rQC.rQR.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(38956);
  }
  
  public void setHeadBgListener(SnsHeader.b paramb)
  {
    this.rQE = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(38955);
    this.cpW = paramString;
    if ((this.rQC != null) && (this.rQC.rQR != null)) {
      this.rQC.rQR.setSessionId(paramString);
    }
    AppMethodBeat.o(38955);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(38954);
    if ((this.rQC != null) && (this.rQC.rQR != null)) {
      this.rQC.rQR.setStoryAction(parama);
    }
    AppMethodBeat.o(38954);
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(38953);
    this.type = paramInt;
    if ((paramInt == 1) && (this.rQC.rEI != null)) {
      this.rQC.rEI.setVisibility(8);
    }
    if ((this.rQC != null) && (this.rQC.rQR != null)) {
      this.rQC.rQR.setSnsType(paramInt);
    }
    AppMethodBeat.o(38953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */