package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class an
  implements ag
{
  private int QzF;
  private com.tencent.mm.modelsns.l RcD;
  private String RcE;
  private int Rcy;
  private CdnImageView Rcz;
  private boolean Rei;
  private boolean Rej;
  WXMediaMessage Rek;
  private Bitmap RfI;
  ImageView RfJ;
  private String appName;
  String appid;
  private View doN;
  boolean hLy;
  MMActivity lzt;
  String mediaId;
  private IListener rDF;
  private TextView titleTv;
  private TextView ycd;
  
  public an(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(97981);
    this.Rek = null;
    this.Rcz = null;
    this.titleTv = null;
    this.ycd = null;
    this.appid = "";
    this.appName = "";
    this.Rei = false;
    this.Rej = false;
    this.hLy = false;
    this.RcD = null;
    this.QzF = 1;
    this.RcE = "";
    this.rDF = new MusicWidget.1(this, com.tencent.mm.app.f.hfK);
    this.lzt = paramMMActivity;
    this.rDF.alive();
    AppMethodBeat.o(97981);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97985);
    al.hgx();
    paramString1 = bf.c(this.Rek, paramString1, this.appid, this.appName);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[] { this.appid, this.appName });
      AppMethodBeat.o(97985);
      return false;
    }
    paramPInt.value = paramString1.cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      paramString1.akL(4);
    }
    paramString1.akQ(this.Rcy);
    if (this.Rei) {
      paramString1.akQ(5);
    }
    paramLinkedList = new LinkedList();
    if (paramList1 != null)
    {
      new LinkedList();
      paramPInt = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramString2 = (String)paramList1.next();
        if ((paramPInt != null) && (!paramPInt.contains(paramString2)))
        {
          ffw localffw = new ffw();
          localffw.UserName = paramString2;
          paramLinkedList.add(localffw);
        }
      }
    }
    paramString1.bU(paramLinkedList);
    if (parami != null) {
      paramString1.mm(parami.token, parami.aaTQ);
    }
    paramString1.a(paramdjv);
    if (paramBoolean) {
      paramString1.akR(1);
    }
    for (;;)
    {
      paramString1.kB(paramList2).akO(paramInt1);
      paramString1.i(null, null, null, paramInt4, paramInt5);
      paramString1.df(this.QzF, this.RcE);
      if ((this.Rej) && (this.Rek != null))
      {
        paramString1.aYN(this.Rek.mediaTagName);
        paramString1.aY(this.appid, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramInt1 = paramString1.FW();
      if (this.RcD != null)
      {
        this.RcD.wQ(paramInt1);
        com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
      }
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(97985);
      return false;
      paramString1.akR(0);
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(97982);
    this.Rek = new SendMessageToWX.Req(this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    this.mediaId = this.lzt.getIntent().getStringExtra("Ksnsupload_musicid");
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.appid = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {}
    for (this.QzF = 1;; this.QzF = 0)
    {
      this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
      AppMethodBeat.o(97982);
      return;
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(97984);
    this.doN = af.mU(this.lzt).inflate(b.g.upload_media_music, null);
    this.Rcz = ((CdnImageView)this.doN.findViewById(b.f.image_left));
    this.titleTv = ((TextView)this.doN.findViewById(b.f.titletext));
    this.ycd = ((TextView)this.doN.findViewById(b.f.righttext));
    this.doN.findViewById(b.f.state).setVisibility(8);
    this.titleTv.setText(this.Rek.title);
    if (this.Rek.thumbData != null) {
      this.RfI = BitmapUtil.decodeByteArray(this.Rek.thumbData);
    }
    this.Rcz.setImageBitmap(this.RfI);
    if (!Util.isNullOrNil(this.Rek.description))
    {
      this.ycd.setText(this.Rek.description);
      this.ycd.setVisibility(0);
      this.RfJ = ((ImageView)this.doN.findViewById(b.f.state));
      this.RfJ.setVisibility(0);
      if ((!com.tencent.mm.aw.a.bLk()) || (!this.hLy)) {
        break label273;
      }
      this.RfJ.setImageResource(b.e.music_pauseicon);
    }
    for (;;)
    {
      this.RfJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97980);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (com.tencent.mm.aw.a.bLk()) {
            an.this.hmo();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97980);
            return;
            paramAnonymousView = an.this;
            if (paramAnonymousView.Rek == null) {
              Log.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
            } else {
              new MMHandler(paramAnonymousView.lzt.getMainLooper()).post(new an.2(paramAnonymousView));
            }
          }
        }
      });
      t.c(this.Rcz, this.lzt);
      View localView = this.doN;
      AppMethodBeat.o(97984);
      return localView;
      this.ycd.setVisibility(8);
      break;
      label273:
      this.RfJ.setImageResource(b.e.music_playicon);
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(97986);
    if ((this.RfI != null) && (!this.RfI.isRecycled())) {
      this.RfI.recycle();
    }
    this.rDF.dead();
    if ((com.tencent.mm.aw.a.bLk()) && (this.hLy)) {
      hmo();
    }
    boolean bool = com.tencent.mm.aw.a.bLk();
    AppMethodBeat.o(97986);
    return bool;
  }
  
  final void hmo()
  {
    AppMethodBeat.i(97983);
    new MMHandler(this.lzt.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97978);
        com.tencent.mm.aw.a.bLi();
        an.this.hLy = false;
        AppMethodBeat.o(97978);
      }
    });
    AppMethodBeat.o(97983);
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */