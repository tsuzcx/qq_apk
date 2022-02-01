package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private boolean Dbg;
  private final TimePickerDialog.OnTimeSetListener Dbh;
  private CheckBox QqR;
  private EditText QqS;
  private CheckBox QqT;
  private CheckBox QqU;
  private CheckBox QqV;
  private TextView QqW;
  private TextView QqX;
  private CheckBox QqY;
  private EditText QqZ;
  private CheckBox QrA;
  private EditText QrB;
  private EditText QrC;
  private EditText QrD;
  private Spinner QrE;
  private Spinner QrF;
  private CheckBox QrG;
  private CheckBox QrH;
  private EditText QrI;
  private EditText QrJ;
  private EditText QrK;
  private Spinner QrL;
  private Spinner QrM;
  private CheckBox QrN;
  private CheckBox QrO;
  private EditText QrP;
  private EditText QrQ;
  private EditText QrR;
  private Spinner QrS;
  private Spinner QrT;
  private CheckBox QrU;
  private EditText QrV;
  private CheckBox QrW;
  private EditText QrX;
  private EditText QrY;
  private EditText QrZ;
  private EditText Qra;
  private EditText Qrb;
  private Spinner Qrc;
  private Spinner Qrd;
  private CheckBox Qre;
  private CheckBox Qrf;
  private EditText Qrg;
  private EditText Qrh;
  private EditText Qri;
  private Spinner Qrj;
  private Spinner Qrk;
  private CheckBox Qrl;
  private CheckBox Qrm;
  private EditText Qrn;
  private EditText Qro;
  private EditText Qrp;
  private Spinner Qrq;
  private Spinner Qrr;
  private CheckBox Qrs;
  private CheckBox Qrt;
  private EditText Qru;
  private EditText Qrv;
  private EditText Qrw;
  private Spinner Qrx;
  private Spinner Qry;
  private CheckBox Qrz;
  private CheckBox QsA;
  private CheckBox QsB;
  private EditText QsC;
  private EditText QsD;
  private EditText QsE;
  private Spinner QsF;
  private Spinner QsG;
  private CheckBox QsH;
  private CheckBox QsI;
  private EditText QsJ;
  private EditText QsK;
  private EditText QsL;
  private Spinner QsM;
  private Spinner QsN;
  private CheckBox QsO;
  private CheckBox QsP;
  private EditText QsQ;
  private EditText QsR;
  private EditText QsS;
  private Spinner QsT;
  private Spinner QsU;
  private CheckBox QsV;
  private CheckBox QsW;
  private EditText QsX;
  private EditText QsY;
  private EditText QsZ;
  private EditText Qsa;
  private EditText Qsb;
  private EditText Qsc;
  private Spinner Qsd;
  private Spinner Qse;
  private CheckBox Qsf;
  private CheckBox Qsg;
  private EditText Qsh;
  private EditText Qsi;
  private EditText Qsj;
  private Spinner Qsk;
  private Spinner Qsl;
  private CheckBox Qsm;
  private CheckBox Qsn;
  private EditText Qso;
  private EditText Qsp;
  private EditText Qsq;
  private Spinner Qsr;
  private Spinner Qss;
  private CheckBox Qst;
  private CheckBox Qsu;
  private EditText Qsv;
  private EditText Qsw;
  private EditText Qsx;
  private Spinner Qsy;
  private Spinner Qsz;
  private Spinner Qta;
  private Spinner Qtb;
  private CheckBox Qtc;
  private CheckBox Qtd;
  private EditText Qte;
  private EditText Qtf;
  private EditText Qtg;
  private Spinner Qth;
  private Spinner Qti;
  private CheckBox Qtj;
  private CheckBox Qtk;
  private EditText Qtl;
  private EditText Qtm;
  private EditText Qtn;
  private Spinner Qto;
  private Spinner Qtp;
  private CheckBox Qtq;
  private CheckBox Qtr;
  private EditText Qts;
  private EditText Qtt;
  private EditText Qtu;
  private Spinner Qtv;
  private Spinner Qtw;
  private CheckBox Qtx;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.Dbg = false;
    this.Dbh = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.o(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.o(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    AppMethodBeat.i(39068);
    paramEditor.putBoolean("KEY_HC_ENABLE", WXHardCoderJNI.getEnable());
    paramEditor.putBoolean("KEY_HC_DEBUG", WXHardCoderJNI.getDebug());
    paramEditor.putInt("KEY_HC_RETRY_INTERVAL", WXHardCoderJNI.hcRetryInterval);
    paramEditor.putBoolean("KEY_HC_TIME_LIMIT", WXHardCoderJNI.hcTimeLimit);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_HOUR", WXHardCoderJNI.hcBeginTimeHour);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_MIN", WXHardCoderJNI.hcBeginTimeMin);
    paramEditor.putInt("KEY_HC_END_TIME_HOUR", WXHardCoderJNI.hcEndTimeHour);
    paramEditor.putInt("KEY_HC_END_TIME_MIN", WXHardCoderJNI.hcEndTimeMin);
    paramEditor.putBoolean("KEY_HC_BOOT_ENABLE", WXHardCoderJNI.hcBootEnable);
    paramEditor.putInt("KEY_HC_BOOT_DELEY", WXHardCoderJNI.hcBootDelay);
    paramEditor.putInt("KEY_HC_BOOT_CPU", WXHardCoderJNI.hcBootCPU);
    paramEditor.putInt("KEY_HC_BOOT_IO", WXHardCoderJNI.hcBootIO);
    paramEditor.putBoolean("KEY_HC_BOOT_THR", WXHardCoderJNI.hcBootThr);
    paramEditor.putInt("KEY_HC_BOOT_TIMEOUT", WXHardCoderJNI.hcBootTimeout);
    paramEditor.putLong("KEY_HC_BOOT_ACTION", WXHardCoderJNI.hcBootAction);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_ENABLE", WXHardCoderJNI.hcEnterChattingEnable);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_DELEY", WXHardCoderJNI.hcEnterChattingDelay);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_CPU", WXHardCoderJNI.hcEnterChattingCPU);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_IO", WXHardCoderJNI.hcEnterChattingIO);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_THR", WXHardCoderJNI.hcEnterChattingThr);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_TIMEOUT", WXHardCoderJNI.hcEnterChattingTimeout);
    paramEditor.putLong("KEY_HC_ENTER_CHATTING_ACTION", WXHardCoderJNI.hcEnterChattingAction);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_ENABLE", WXHardCoderJNI.hcQuitChattingEnable);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_DELEY", WXHardCoderJNI.hcQuitChattingDelay);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_CPU", WXHardCoderJNI.hcQuitChattingCPU);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_IO", WXHardCoderJNI.hcQuitChattingIO);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_THR", WXHardCoderJNI.hcQuitChattingThr);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_TIMEOUT", WXHardCoderJNI.hcQuitChattingTimeout);
    paramEditor.putLong("KEY_HC_QUIT_CHATTING_ACTION", WXHardCoderJNI.hcQuitChattingAction);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_ENABLE", WXHardCoderJNI.hcSendMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_MSG_DELEY", WXHardCoderJNI.hcSendMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_MSG_CPU", WXHardCoderJNI.hcSendMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_MSG_IO", WXHardCoderJNI.hcSendMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_THR", WXHardCoderJNI.hcSendMsgThr);
    paramEditor.putInt("KEY_HC_SEND_MSG_TIMEOUT", WXHardCoderJNI.hcSendMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_MSG_ACTION", WXHardCoderJNI.hcSendMsgAction);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", WXHardCoderJNI.hcSendPicMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_DELEY", WXHardCoderJNI.hcSendPicMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_CPU", WXHardCoderJNI.hcSendPicMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_IO", WXHardCoderJNI.hcSendPicMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_THR", WXHardCoderJNI.hcSendPicMsgThr);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", WXHardCoderJNI.hcSendPicMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_PIC_MSG_ACTION", WXHardCoderJNI.hcSendPicMsgAction);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_ENABLE", WXHardCoderJNI.hcReceiveMsgEnable);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_DELEY", WXHardCoderJNI.hcReceiveMsgDelay);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_CPU", WXHardCoderJNI.hcReceiveMsgCPU);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_IO", WXHardCoderJNI.hcReceiveMsgIO);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_THR", WXHardCoderJNI.hcReceiveMsgThr);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_TIMEOUT", WXHardCoderJNI.hcReceiveMsgTimeout);
    paramEditor.putLong("KEY_HC_RECEIVE_MSG_ACTION", WXHardCoderJNI.hcReceiveMsgAction);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", WXHardCoderJNI.hcUpdateChatroomEnable);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_DELEY", WXHardCoderJNI.hcUpdateChatroomDelay);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_CPU", WXHardCoderJNI.hcUpdateChatroomCPU);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_IO", WXHardCoderJNI.hcUpdateChatroomIO);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_THR", WXHardCoderJNI.hcUpdateChatroomThr);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", WXHardCoderJNI.hcUpdateChatroomTimeout);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_ACTION", WXHardCoderJNI.hcUpdateChatroomAction);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", WXHardCoderJNI.hcUpdateChatroomMemberCount);
    paramEditor.putBoolean("KEY_HC_DB_ENABLE", WXHardCoderJNI.hcDBEnable);
    paramEditor.putInt("KEY_HC_DB_DELEY_QUERY", WXHardCoderJNI.hcDBDelayQuery);
    paramEditor.putInt("KEY_HC_DB_DELEY_WRITE", WXHardCoderJNI.hcDBDelayWrite);
    paramEditor.putInt("KEY_HC_DB_CPU", WXHardCoderJNI.hcDBCPU);
    paramEditor.putInt("KEY_HC_DB_IO", WXHardCoderJNI.hcDBIO);
    paramEditor.putBoolean("KEY_HC_DB_THR", WXHardCoderJNI.hcDBThr);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeout);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeoutBusy);
    paramEditor.putLong("KEY_HC_DB_ACTION_QUERY", WXHardCoderJNI.hcDBActionQuery);
    paramEditor.putLong("KEY_HC_DB_ACTION_WRITE", WXHardCoderJNI.hcDBActionWrite);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", WXHardCoderJNI.hcEncodeVideoEnable);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_DELEY", WXHardCoderJNI.hcEncodeVideoDelay);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_CPU", WXHardCoderJNI.hcEncodeVideoCPU);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_IO", WXHardCoderJNI.hcEncodeVideoIO);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_THR", WXHardCoderJNI.hcEncodeVideoThr);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", WXHardCoderJNI.hcEncodeVideoTimeout);
    paramEditor.putLong("KEY_HC_ENCODE_VIDEO_ACTION", WXHardCoderJNI.hcEncodeVideoAction);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_ENABLE", WXHardCoderJNI.hcDecodePicEnable);
    paramEditor.putInt("KEY_HC_DECODE_PIC_DELEY", WXHardCoderJNI.hcDecodePicDelay);
    paramEditor.putInt("KEY_HC_DECODE_PIC_CPU", WXHardCoderJNI.hcDecodePicCPU);
    paramEditor.putInt("KEY_HC_DECODE_PIC_IO", WXHardCoderJNI.hcDecodePicIO);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_THR", WXHardCoderJNI.hcDecodePicThr);
    paramEditor.putInt("KEY_HC_DECODE_PIC_TIMEOUT", WXHardCoderJNI.hcDecodePicTimeout);
    paramEditor.putLong("KEY_HC_DECODE_PIC_ACTION", WXHardCoderJNI.hcDecodePicAction);
    paramEditor.putBoolean("KEY_HC_GIF_ENABLE", WXHardCoderJNI.hcGifEnable);
    paramEditor.putInt("KEY_HC_GIF_DELEY", WXHardCoderJNI.hcGifDelay);
    paramEditor.putInt("KEY_HC_GIF_CPU", WXHardCoderJNI.hcGifCPU);
    paramEditor.putInt("KEY_HC_GIF_IO", WXHardCoderJNI.hcGifIO);
    paramEditor.putBoolean("KEY_HC_GIF_THR", WXHardCoderJNI.hcGifThr);
    paramEditor.putInt("KEY_HC_GIF_TIMEOUT", WXHardCoderJNI.hcGifTimeout);
    paramEditor.putLong("KEY_HC_GIF_ACTION", WXHardCoderJNI.hcGifAction);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_ENABLE", WXHardCoderJNI.hcGifFrameEnable);
    paramEditor.putInt("KEY_HC_GIF_FRAME_DELEY", WXHardCoderJNI.hcGifFrameDelay);
    paramEditor.putInt("KEY_HC_GIF_FRAME_CPU", WXHardCoderJNI.hcGifFrameCPU);
    paramEditor.putInt("KEY_HC_GIF_FRAME_IO", WXHardCoderJNI.hcGifFrameIO);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_THR", WXHardCoderJNI.hcGifFrameThr);
    paramEditor.putInt("KEY_HC_GIF_FRAME_TIMEOUT", WXHardCoderJNI.hcGifFrameTimeout);
    paramEditor.putLong("KEY_HC_GIF_FRAME_ACTION", WXHardCoderJNI.hcGifFrameAction);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_ENABLE", WXHardCoderJNI.hcSNSScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_DELEY", WXHardCoderJNI.hcSNSScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_CPU", WXHardCoderJNI.hcSNSScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_IO", WXHardCoderJNI.hcSNSScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_THR", WXHardCoderJNI.hcSNSScrollThr);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_SCROLL_ACTION", WXHardCoderJNI.hcSNSScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", WXHardCoderJNI.hcSNSUserScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_DELEY", WXHardCoderJNI.hcSNSUserScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_CPU", WXHardCoderJNI.hcSNSUserScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_IO", WXHardCoderJNI.hcSNSUserScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_THR", WXHardCoderJNI.hcSNSUserScrollThr);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSUserScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_USER_SCROLL_ACTION", WXHardCoderJNI.hcSNSUserScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", WXHardCoderJNI.hcSNSMsgScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_DELEY", WXHardCoderJNI.hcSNSMsgScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_CPU", WXHardCoderJNI.hcSNSMsgScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_IO", WXHardCoderJNI.hcSNSMsgScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_THR", WXHardCoderJNI.hcSNSMsgScrollThr);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSMsgScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_MSG_SCROLL_ACTION", WXHardCoderJNI.hcSNSMsgScrollAction);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", WXHardCoderJNI.hcMediaGalleryScrollEnable);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", WXHardCoderJNI.hcMediaGalleryScrollDelay);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", WXHardCoderJNI.hcMediaGalleryScrollCPU);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", WXHardCoderJNI.hcMediaGalleryScrollIO);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", WXHardCoderJNI.hcMediaGalleryScrollThr);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    paramEditor.putLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", WXHardCoderJNI.hcMediaGalleryScrollAction);
    paramEditor.putBoolean("KEY_HCALBUM_SCROLL_ENABLE", WXHardCoderJNI.hcAlbumScrollEnable);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_DELEY", WXHardCoderJNI.hcAlbumScrollDelay);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_CPU", WXHardCoderJNI.hcAlbumScrollCPU);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_IO", WXHardCoderJNI.hcAlbumScrollIO);
    paramEditor.putBoolean("KEY_HC_ALBUM_SCROLL_THR", WXHardCoderJNI.hcAlbumScrollThr);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", WXHardCoderJNI.hcAlbumScrollTimeout);
    paramEditor.putLong("KEY_HC_ALBUM_SCROLL_ACTION", WXHardCoderJNI.hcAlbumScrollAction);
    paramEditor.apply();
    AppMethodBeat.o(39068);
  }
  
  private static String i(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = LocaleUtil.loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str2 = LocaleUtil.getApplicationLanguage();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, LocaleUtil.transLanguageToLocale(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = f.v(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495007;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(2131765411);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39059);
        HardCoderSettingUI.this.finish();
        AppMethodBeat.o(39059);
        return true;
      }
    });
    paramBundle = getContext().getSharedPreferences("hardcoder_setting", 0);
    if (!paramBundle.contains("KEY_HC_ENABLE")) {
      b(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.QqT = ((CheckBox)findViewById(2131298606));
    this.QqT.setChecked(WXHardCoderJNI.getDebug());
    this.QqR = ((CheckBox)findViewById(2131298612));
    this.QqR.setChecked(WXHardCoderJNI.getEnable());
    this.QqS = ((EditText)findViewById(2131307044));
    this.QqS.setText(WXHardCoderJNI.hcRetryInterval);
    this.QqU = ((CheckBox)findViewById(2131298604));
    this.QqV = ((CheckBox)findViewById(2131298608));
    this.QqV.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.QqW = ((TextView)findViewById(2131297348));
    this.QqX = ((TextView)findViewById(2131300126));
    this.QqW.setText(i(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.QqX.setText(i(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.QqW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39060);
      }
    });
    this.QqX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39061);
      }
    });
    this.QqY = ((CheckBox)findViewById(2131298601));
    this.QqY.setChecked(WXHardCoderJNI.hcBootEnable);
    this.QqZ = ((EditText)findViewById(2131299459));
    this.QqZ.setText(WXHardCoderJNI.hcBootDelay);
    this.Qra = ((EditText)findViewById(2131309107));
    this.Qra.setText(WXHardCoderJNI.hcBootTimeout);
    this.Qra.setSelection(this.Qra.getText().length());
    this.Qrb = ((EditText)findViewById(2131296376));
    this.Qrb.setText(WXHardCoderJNI.hcBootAction);
    this.Qrc = ((Spinner)findViewById(2131299301));
    this.Qrc.setSelection(WXHardCoderJNI.hcBootCPU);
    this.Qrd = ((Spinner)findViewById(2131302756));
    this.Qrd.setSelection(WXHardCoderJNI.hcBootIO);
    this.Qre = ((CheckBox)findViewById(2131309050));
    this.Qre.setChecked(WXHardCoderJNI.hcBootThr);
    this.Qrf = ((CheckBox)findViewById(2131298609));
    this.Qrf.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.Qrg = ((EditText)findViewById(2131299463));
    this.Qrg.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.Qrh = ((EditText)findViewById(2131309111));
    this.Qrh.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.Qrh.setSelection(this.Qrh.getText().length());
    this.Qri = ((EditText)findViewById(2131296386));
    this.Qri.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.Qrj = ((Spinner)findViewById(2131299304));
    this.Qrj.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.Qrk = ((Spinner)findViewById(2131302759));
    this.Qrk.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.Qrl = ((CheckBox)findViewById(2131309053));
    this.Qrl.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.Qrm = ((CheckBox)findViewById(2131298620));
    this.Qrm.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.Qrn = ((EditText)findViewById(2131299467));
    this.Qrn.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.Qro = ((EditText)findViewById(2131309115));
    this.Qro.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.Qro.setSelection(this.Qro.getText().length());
    this.Qrp = ((EditText)findViewById(2131296403));
    this.Qrp.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.Qrq = ((Spinner)findViewById(2131299308));
    this.Qrq.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.Qrr = ((Spinner)findViewById(2131302763));
    this.Qrr.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.Qrs = ((CheckBox)findViewById(2131309057));
    this.Qrs.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.Qrt = ((CheckBox)findViewById(2131298623));
    this.Qrt.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.Qru = ((EditText)findViewById(2131299469));
    this.Qru.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.Qrv = ((EditText)findViewById(2131309117));
    this.Qrv.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.Qrv.setSelection(this.Qrv.getText().length());
    this.Qrw = ((EditText)findViewById(2131296406));
    this.Qrw.setText(WXHardCoderJNI.hcSendMsgAction);
    this.Qrx = ((Spinner)findViewById(2131299310));
    this.Qrx.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.Qry = ((Spinner)findViewById(2131302765));
    this.Qry.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.Qrz = ((CheckBox)findViewById(2131309059));
    this.Qrz.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.QrA = ((CheckBox)findViewById(2131298624));
    this.QrA.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.QrB = ((EditText)findViewById(2131299470));
    this.QrB.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.QrC = ((EditText)findViewById(2131309118));
    this.QrC.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.QrC.setSelection(this.QrC.getText().length());
    this.QrD = ((EditText)findViewById(2131296407));
    this.QrD.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.QrE = ((Spinner)findViewById(2131299311));
    this.QrE.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.QrF = ((Spinner)findViewById(2131302766));
    this.QrF.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.QrG = ((CheckBox)findViewById(2131309060));
    this.QrG.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.QrH = ((CheckBox)findViewById(2131298621));
    this.QrH.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.QrI = ((EditText)findViewById(2131299468));
    this.QrI.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.QrJ = ((EditText)findViewById(2131309116));
    this.QrJ.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.QrJ.setSelection(this.QrJ.getText().length());
    this.QrK = ((EditText)findViewById(2131296404));
    this.QrK.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.QrL = ((Spinner)findViewById(2131299309));
    this.QrL.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.QrM = ((Spinner)findViewById(2131302764));
    this.QrM.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.QrN = ((CheckBox)findViewById(2131309058));
    this.QrN.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.QrO = ((CheckBox)findViewById(2131298637));
    this.QrO.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.QrP = ((EditText)findViewById(2131299474));
    this.QrP.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.QrQ = ((EditText)findViewById(2131309122));
    this.QrQ.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.QrQ.setSelection(this.QrQ.getText().length());
    this.QrR = ((EditText)findViewById(2131296417));
    this.QrR.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.QrS = ((Spinner)findViewById(2131299315));
    this.QrS.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.QrT = ((Spinner)findViewById(2131302770));
    this.QrT.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.QrU = ((CheckBox)findViewById(2131309064));
    this.QrU.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.QrV = ((EditText)findViewById(2131309600));
    this.QrV.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.QrW = ((CheckBox)findViewById(2131298605));
    this.QrW.setChecked(WXHardCoderJNI.hcDBEnable);
    this.QrX = ((EditText)findViewById(2131299460));
    this.QrX.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.QrY = ((EditText)findViewById(2131299461));
    this.QrY.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.QrZ = ((EditText)findViewById(2131309108));
    this.QrZ.setText(WXHardCoderJNI.hcDBTimeout);
    this.Qsa = ((EditText)findViewById(2131309109));
    this.Qsa.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.Qsb = ((EditText)findViewById(2131296381));
    this.Qsb.setText(WXHardCoderJNI.hcDBActionQuery);
    this.Qsc = ((EditText)findViewById(2131296382));
    this.Qsc.setText(WXHardCoderJNI.hcDBActionWrite);
    this.Qsd = ((Spinner)findViewById(2131299302));
    this.Qsd.setSelection(WXHardCoderJNI.hcDBCPU);
    this.Qse = ((Spinner)findViewById(2131302757));
    this.Qse.setSelection(WXHardCoderJNI.hcDBIO);
    this.Qsf = ((CheckBox)findViewById(2131309051));
    this.Qsf.setChecked(WXHardCoderJNI.hcDBThr);
    this.Qsg = ((CheckBox)findViewById(2131298638));
    this.Qsg.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.Qsh = ((EditText)findViewById(2131299475));
    this.Qsh.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.Qsi = ((EditText)findViewById(2131309123));
    this.Qsi.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.Qsj = ((EditText)findViewById(2131296418));
    this.Qsj.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.Qsk = ((Spinner)findViewById(2131299316));
    this.Qsk.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.Qsl = ((Spinner)findViewById(2131302771));
    this.Qsl.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.Qsm = ((CheckBox)findViewById(2131309065));
    this.Qsm.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.Qsn = ((CheckBox)findViewById(2131298607));
    this.Qsn.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.Qso = ((EditText)findViewById(2131299462));
    this.Qso.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.Qsp = ((EditText)findViewById(2131309110));
    this.Qsp.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.Qsq = ((EditText)findViewById(2131296383));
    this.Qsq.setText(WXHardCoderJNI.hcDecodePicAction);
    this.Qsr = ((Spinner)findViewById(2131299303));
    this.Qsr.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.Qss = ((Spinner)findViewById(2131302758));
    this.Qss.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.Qst = ((CheckBox)findViewById(2131309052));
    this.Qst.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.Qsu = ((CheckBox)findViewById(2131298610));
    this.Qsu.setChecked(WXHardCoderJNI.hcGifEnable);
    this.Qsv = ((EditText)findViewById(2131299464));
    this.Qsv.setText(WXHardCoderJNI.hcGifDelay);
    this.Qsw = ((EditText)findViewById(2131309112));
    this.Qsw.setText(WXHardCoderJNI.hcGifTimeout);
    this.Qsx = ((EditText)findViewById(2131296387));
    this.Qsx.setText(WXHardCoderJNI.hcGifAction);
    this.Qsy = ((Spinner)findViewById(2131299305));
    this.Qsy.setSelection(WXHardCoderJNI.hcGifCPU);
    this.Qsz = ((Spinner)findViewById(2131302760));
    this.Qsz.setSelection(WXHardCoderJNI.hcGifIO);
    this.QsA = ((CheckBox)findViewById(2131309054));
    this.QsA.setChecked(WXHardCoderJNI.hcGifThr);
    this.QsB = ((CheckBox)findViewById(2131298611));
    this.QsB.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.QsC = ((EditText)findViewById(2131299465));
    this.QsC.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.QsD = ((EditText)findViewById(2131309113));
    this.QsD.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.QsE = ((EditText)findViewById(2131296388));
    this.QsE.setText(WXHardCoderJNI.hcGifFrameAction);
    this.QsF = ((Spinner)findViewById(2131299306));
    this.QsF.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.QsG = ((Spinner)findViewById(2131302761));
    this.QsG.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.QsH = ((CheckBox)findViewById(2131309055));
    this.QsH.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.QsI = ((CheckBox)findViewById(2131298628));
    this.QsI.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.QsJ = ((EditText)findViewById(2131299472));
    this.QsJ.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.QsK = ((EditText)findViewById(2131309120));
    this.QsK.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.QsL = ((EditText)findViewById(2131296410));
    this.QsL.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.QsM = ((Spinner)findViewById(2131299313));
    this.QsM.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.QsN = ((Spinner)findViewById(2131302768));
    this.QsN.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.QsO = ((CheckBox)findViewById(2131309062));
    this.QsO.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.QsP = ((CheckBox)findViewById(2131298629));
    this.QsP.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.QsQ = ((EditText)findViewById(2131299473));
    this.QsQ.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.QsR = ((EditText)findViewById(2131309121));
    this.QsR.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.QsS = ((EditText)findViewById(2131296411));
    this.QsS.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.QsT = ((Spinner)findViewById(2131299314));
    this.QsT.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.QsU = ((Spinner)findViewById(2131302769));
    this.QsU.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.QsV = ((CheckBox)findViewById(2131309063));
    this.QsV.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.QsW = ((CheckBox)findViewById(2131298627));
    this.QsW.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.QsX = ((EditText)findViewById(2131299471));
    this.QsX.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.QsY = ((EditText)findViewById(2131309119));
    this.QsY.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.QsZ = ((EditText)findViewById(2131296409));
    this.QsZ.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.Qta = ((Spinner)findViewById(2131299312));
    this.Qta.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.Qtb = ((Spinner)findViewById(2131302767));
    this.Qtb.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.Qtc = ((CheckBox)findViewById(2131309061));
    this.Qtc.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.Qtd = ((CheckBox)findViewById(2131298615));
    this.Qtd.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.Qte = ((EditText)findViewById(2131299466));
    this.Qte.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.Qtf = ((EditText)findViewById(2131309114));
    this.Qtf.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.Qtg = ((EditText)findViewById(2131296393));
    this.Qtg.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.Qth = ((Spinner)findViewById(2131299307));
    this.Qth.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.Qti = ((Spinner)findViewById(2131302762));
    this.Qti.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.Qtj = ((CheckBox)findViewById(2131309056));
    this.Qtj.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.Qtk = ((CheckBox)findViewById(2131298599));
    this.Qtk.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.Qtl = ((EditText)findViewById(2131299457));
    this.Qtl.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.Qtm = ((EditText)findViewById(2131309105));
    this.Qtm.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.Qtn = ((EditText)findViewById(2131296362));
    this.Qtn.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.Qto = ((Spinner)findViewById(2131299299));
    this.Qto.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.Qtp = ((Spinner)findViewById(2131302754));
    this.Qtp.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.Qtq = ((CheckBox)findViewById(2131309048));
    this.Qtq.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.Qtr = ((CheckBox)findViewById(2131298600));
    this.Qtr.setChecked(WXHardCoderJNI.hcBizEnable);
    this.Qts = ((EditText)findViewById(2131299458));
    this.Qts.setText(WXHardCoderJNI.hcBizDelay);
    this.Qtt = ((EditText)findViewById(2131309106));
    this.Qtt.setText(WXHardCoderJNI.hcBizTimeout);
    this.Qtu = ((EditText)findViewById(2131296375));
    this.Qtu.setText(WXHardCoderJNI.hcBizAction);
    this.Qtv = ((Spinner)findViewById(2131299300));
    this.Qtv.setSelection(WXHardCoderJNI.hcBizCPU);
    this.Qtw = ((Spinner)findViewById(2131302755));
    this.Qtw.setSelection(WXHardCoderJNI.hcBizIO);
    this.Qtx = ((CheckBox)findViewById(2131309049));
    this.Qtx.setChecked(WXHardCoderJNI.hcBizThr);
    this.QqR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        boolean bool = HardCoderSettingUI.a(HardCoderSettingUI.this).isChecked();
        HardCoderSettingUI.b(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.c(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.d(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.e(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.f(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.g(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.h(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.i(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.j(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.k(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.l(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.m(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.n(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.o(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.p(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.q(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.r(HardCoderSettingUI.this).setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39062);
      }
    });
    AppMethodBeat.o(39065);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(39066);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(39066);
      return null;
    }
    if (this.Dbg)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.Dbh, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.Dbh, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    Log.i("HardCoderSettingUI", "save");
    if ((this.QqR.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.QqR.isChecked());
      WXHardCoderJNI.initHardCoder(com.tencent.mm.plugin.hardcoder.a.dYI(), com.tencent.mm.plugin.hardcoder.a.dYI(), null);
    }
    WXHardCoderJNI.setDebug(this.QqT.isChecked());
    WXHardCoderJNI.setHcEnable(this.QqR.isChecked());
    WXHardCoderJNI.hcRetryInterval = Util.getInt(this.QqS.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.QqV.isChecked();
    WXHardCoderJNI.hcBootEnable = this.QqY.isChecked();
    WXHardCoderJNI.hcBootDelay = Util.getInt(this.QqZ.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.Qrc.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.Qrd.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.Qre.isChecked();
    WXHardCoderJNI.hcBootTimeout = Util.getInt(this.Qra.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = Util.getLong(this.Qrb.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.Qrf.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = Util.getInt(this.Qrg.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.Qrj.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.Qrk.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.Qrl.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = Util.getInt(this.Qrh.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = Util.getLong(this.Qri.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.Qrm.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = Util.getInt(this.Qrn.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.Qrq.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.Qrr.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.Qrs.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = Util.getInt(this.Qro.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = Util.getLong(this.Qrp.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.Qrt.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = Util.getInt(this.Qru.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.Qrx.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.Qry.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.Qrz.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = Util.getInt(this.Qrv.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = Util.getLong(this.Qrw.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.QrA.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = Util.getInt(this.QrB.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.QrE.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.QrF.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.QrG.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = Util.getInt(this.QrC.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = Util.getLong(this.QrD.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.QrH.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = Util.getInt(this.QrI.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.QrL.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.QrM.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.QrN.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = Util.getInt(this.QrJ.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = Util.getLong(this.QrK.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.QrO.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = Util.getInt(this.QrP.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.QrS.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.QrT.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.QrU.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = Util.getInt(this.QrQ.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = Util.getLong(this.QrR.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = Util.getLong(this.QrV.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.QrW.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = Util.getInt(this.QrX.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = Util.getInt(this.QrY.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.Qrc.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.Qrd.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.Qre.isChecked();
    WXHardCoderJNI.hcDBTimeout = Util.getInt(this.QrZ.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = Util.getInt(this.Qsa.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = Util.getLong(this.Qsb.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = Util.getLong(this.Qsc.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.Qsg.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = Util.getInt(this.Qsh.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.Qsk.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.Qsl.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.Qsm.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = Util.getInt(this.Qsi.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = Util.getLong(this.Qsj.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.Qsn.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = Util.getInt(this.Qso.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.Qsr.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.Qss.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.Qst.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = Util.getInt(this.Qsp.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = Util.getLong(this.Qsq.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.Qsu.isChecked();
    WXHardCoderJNI.hcGifDelay = Util.getInt(this.Qsv.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.Qsy.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.Qsz.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.QsA.isChecked();
    WXHardCoderJNI.hcGifTimeout = Util.getInt(this.Qsw.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = Util.getLong(this.Qsx.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.QsB.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = Util.getInt(this.QsC.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.QsF.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.QsG.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.QsH.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = Util.getInt(this.QsD.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = Util.getLong(this.QsE.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.QsI.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = Util.getInt(this.QsJ.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.QsM.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.QsN.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.QsO.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = Util.getInt(this.QsK.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = Util.getLong(this.QsL.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.QsP.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = Util.getInt(this.QsQ.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.QsT.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.QsU.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.QsV.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = Util.getInt(this.QsR.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = Util.getLong(this.QsS.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.QsW.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = Util.getInt(this.QsX.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.Qta.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.Qtb.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.Qtc.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = Util.getInt(this.QsY.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = Util.getLong(this.QsZ.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.Qtd.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = Util.getInt(this.Qte.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.Qth.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.Qti.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.Qtj.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = Util.getInt(this.Qtf.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = Util.getLong(this.Qtg.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.Qtk.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = Util.getInt(this.Qtl.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.Qto.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.Qtp.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.Qtq.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = Util.getInt(this.Qtm.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = Util.getLong(this.Qtn.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.Qtr.isChecked();
    WXHardCoderJNI.hcBizDelay = Util.getInt(this.Qts.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.Qtv.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.Qtw.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.Qtx.isChecked();
    WXHardCoderJNI.hcBizTimeout = Util.getInt(this.Qtt.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = Util.getLong(this.Qtu.getText().toString(), WXHardCoderJNI.hcBizAction);
    b(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_SETTING);
    super.onDestroy();
    AppMethodBeat.o(39067);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */