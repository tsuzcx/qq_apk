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
import com.tencent.mm.plugin.hardcoder.a;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private CheckBox HnV;
  private EditText HnW;
  private CheckBox HnX;
  private CheckBox HnY;
  private CheckBox HnZ;
  private EditText HoA;
  private Spinner HoB;
  private Spinner HoC;
  private CheckBox HoD;
  private CheckBox HoE;
  private EditText HoF;
  private EditText HoG;
  private EditText HoH;
  private Spinner HoI;
  private Spinner HoJ;
  private CheckBox HoK;
  private CheckBox HoL;
  private EditText HoM;
  private EditText HoN;
  private EditText HoO;
  private Spinner HoP;
  private Spinner HoQ;
  private CheckBox HoR;
  private CheckBox HoS;
  private EditText HoT;
  private EditText HoU;
  private EditText HoV;
  private Spinner HoW;
  private Spinner HoX;
  private CheckBox HoY;
  private EditText HoZ;
  private TextView Hoa;
  private TextView Hob;
  private CheckBox Hoc;
  private EditText Hod;
  private EditText Hoe;
  private EditText Hof;
  private Spinner Hog;
  private Spinner Hoh;
  private CheckBox Hoi;
  private CheckBox Hoj;
  private EditText Hok;
  private EditText Hol;
  private EditText Hom;
  private Spinner Hon;
  private Spinner Hoo;
  private CheckBox Hop;
  private CheckBox Hoq;
  private EditText Hor;
  private EditText Hos;
  private EditText Hot;
  private Spinner Hou;
  private Spinner Hov;
  private CheckBox How;
  private CheckBox Hox;
  private EditText Hoy;
  private EditText Hoz;
  private EditText HpA;
  private EditText HpB;
  private Spinner HpC;
  private Spinner HpD;
  private CheckBox HpE;
  private CheckBox HpF;
  private EditText HpG;
  private EditText HpH;
  private EditText HpI;
  private Spinner HpJ;
  private Spinner HpK;
  private CheckBox HpL;
  private CheckBox HpM;
  private EditText HpN;
  private EditText HpO;
  private EditText HpP;
  private Spinner HpQ;
  private Spinner HpR;
  private CheckBox HpS;
  private CheckBox HpT;
  private EditText HpU;
  private EditText HpV;
  private EditText HpW;
  private Spinner HpX;
  private Spinner HpY;
  private CheckBox HpZ;
  private CheckBox Hpa;
  private EditText Hpb;
  private EditText Hpc;
  private EditText Hpd;
  private EditText Hpe;
  private EditText Hpf;
  private EditText Hpg;
  private Spinner Hph;
  private Spinner Hpi;
  private CheckBox Hpj;
  private CheckBox Hpk;
  private EditText Hpl;
  private EditText Hpm;
  private EditText Hpn;
  private Spinner Hpo;
  private Spinner Hpp;
  private CheckBox Hpq;
  private CheckBox Hpr;
  private EditText Hps;
  private EditText Hpt;
  private EditText Hpu;
  private Spinner Hpv;
  private Spinner Hpw;
  private CheckBox Hpx;
  private CheckBox Hpy;
  private EditText Hpz;
  private Spinner HqA;
  private CheckBox HqB;
  private CheckBox Hqa;
  private EditText Hqb;
  private EditText Hqc;
  private EditText Hqd;
  private Spinner Hqe;
  private Spinner Hqf;
  private CheckBox Hqg;
  private CheckBox Hqh;
  private EditText Hqi;
  private EditText Hqj;
  private EditText Hqk;
  private Spinner Hql;
  private Spinner Hqm;
  private CheckBox Hqn;
  private CheckBox Hqo;
  private EditText Hqp;
  private EditText Hqq;
  private EditText Hqr;
  private Spinner Hqs;
  private Spinner Hqt;
  private CheckBox Hqu;
  private CheckBox Hqv;
  private EditText Hqw;
  private EditText Hqx;
  private EditText Hqy;
  private Spinner Hqz;
  private boolean wgj;
  private final TimePickerDialog.OnTimeSetListener wgk;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.wgj = false;
    this.wgk = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.k(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.k(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void a(SharedPreferences.Editor paramEditor)
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
  
  private static String f(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = ac.g(paramContext.getSharedPreferences(aj.eFD(), 0));
    String str2 = ac.eFu();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ac.aFt(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = h.t(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494430;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(2131763241);
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
      a(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.HnX = ((CheckBox)findViewById(2131298223));
    this.HnX.setChecked(WXHardCoderJNI.getDebug());
    this.HnV = ((CheckBox)findViewById(2131298229));
    this.HnV.setChecked(WXHardCoderJNI.getEnable());
    this.HnW = ((EditText)findViewById(2131304148));
    this.HnW.setText(WXHardCoderJNI.hcRetryInterval);
    this.HnY = ((CheckBox)findViewById(2131298221));
    this.HnZ = ((CheckBox)findViewById(2131298225));
    this.HnZ.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.Hoa = ((TextView)findViewById(2131297199));
    this.Hob = ((TextView)findViewById(2131299490));
    this.Hoa.setText(f(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.Hob.setText(f(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.Hoa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        AppMethodBeat.o(39060);
      }
    });
    this.Hob.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        AppMethodBeat.o(39061);
      }
    });
    this.Hoc = ((CheckBox)findViewById(2131298218));
    this.Hoc.setChecked(WXHardCoderJNI.hcBootEnable);
    this.Hod = ((EditText)findViewById(2131298965));
    this.Hod.setText(WXHardCoderJNI.hcBootDelay);
    this.Hoe = ((EditText)findViewById(2131305827));
    this.Hoe.setText(WXHardCoderJNI.hcBootTimeout);
    this.Hoe.setSelection(this.Hoe.getText().length());
    this.Hof = ((EditText)findViewById(2131296353));
    this.Hof.setText(WXHardCoderJNI.hcBootAction);
    this.Hog = ((Spinner)findViewById(2131298836));
    this.Hog.setSelection(WXHardCoderJNI.hcBootCPU);
    this.Hoh = ((Spinner)findViewById(2131301102));
    this.Hoh.setSelection(WXHardCoderJNI.hcBootIO);
    this.Hoi = ((CheckBox)findViewById(2131305775));
    this.Hoi.setChecked(WXHardCoderJNI.hcBootThr);
    this.Hoj = ((CheckBox)findViewById(2131298226));
    this.Hoj.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.Hok = ((EditText)findViewById(2131298969));
    this.Hok.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.Hol = ((EditText)findViewById(2131305831));
    this.Hol.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.Hol.setSelection(this.Hol.getText().length());
    this.Hom = ((EditText)findViewById(2131296363));
    this.Hom.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.Hon = ((Spinner)findViewById(2131298839));
    this.Hon.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.Hoo = ((Spinner)findViewById(2131301105));
    this.Hoo.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.Hop = ((CheckBox)findViewById(2131305778));
    this.Hop.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.Hoq = ((CheckBox)findViewById(2131298236));
    this.Hoq.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.Hor = ((EditText)findViewById(2131298973));
    this.Hor.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.Hos = ((EditText)findViewById(2131305835));
    this.Hos.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.Hos.setSelection(this.Hos.getText().length());
    this.Hot = ((EditText)findViewById(2131296378));
    this.Hot.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.Hou = ((Spinner)findViewById(2131298843));
    this.Hou.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.Hov = ((Spinner)findViewById(2131301109));
    this.Hov.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.How = ((CheckBox)findViewById(2131305782));
    this.How.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.Hox = ((CheckBox)findViewById(2131298239));
    this.Hox.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.Hoy = ((EditText)findViewById(2131298975));
    this.Hoy.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.Hoz = ((EditText)findViewById(2131305837));
    this.Hoz.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.Hoz.setSelection(this.Hoz.getText().length());
    this.HoA = ((EditText)findViewById(2131296381));
    this.HoA.setText(WXHardCoderJNI.hcSendMsgAction);
    this.HoB = ((Spinner)findViewById(2131298845));
    this.HoB.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.HoC = ((Spinner)findViewById(2131301111));
    this.HoC.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.HoD = ((CheckBox)findViewById(2131305784));
    this.HoD.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.HoE = ((CheckBox)findViewById(2131298240));
    this.HoE.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.HoF = ((EditText)findViewById(2131298976));
    this.HoF.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.HoG = ((EditText)findViewById(2131305838));
    this.HoG.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.HoG.setSelection(this.HoG.getText().length());
    this.HoH = ((EditText)findViewById(2131296382));
    this.HoH.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.HoI = ((Spinner)findViewById(2131298846));
    this.HoI.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.HoJ = ((Spinner)findViewById(2131301112));
    this.HoJ.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.HoK = ((CheckBox)findViewById(2131305785));
    this.HoK.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.HoL = ((CheckBox)findViewById(2131298237));
    this.HoL.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.HoM = ((EditText)findViewById(2131298974));
    this.HoM.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.HoN = ((EditText)findViewById(2131305836));
    this.HoN.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.HoN.setSelection(this.HoN.getText().length());
    this.HoO = ((EditText)findViewById(2131296379));
    this.HoO.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.HoP = ((Spinner)findViewById(2131298844));
    this.HoP.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.HoQ = ((Spinner)findViewById(2131301110));
    this.HoQ.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.HoR = ((CheckBox)findViewById(2131305783));
    this.HoR.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.HoS = ((CheckBox)findViewById(2131298253));
    this.HoS.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.HoT = ((EditText)findViewById(2131298980));
    this.HoT.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.HoU = ((EditText)findViewById(2131305842));
    this.HoU.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.HoU.setSelection(this.HoU.getText().length());
    this.HoV = ((EditText)findViewById(2131296392));
    this.HoV.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.HoW = ((Spinner)findViewById(2131298850));
    this.HoW.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.HoX = ((Spinner)findViewById(2131301116));
    this.HoX.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.HoY = ((CheckBox)findViewById(2131305789));
    this.HoY.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.HoZ = ((EditText)findViewById(2131306202));
    this.HoZ.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.Hpa = ((CheckBox)findViewById(2131298222));
    this.Hpa.setChecked(WXHardCoderJNI.hcDBEnable);
    this.Hpb = ((EditText)findViewById(2131298966));
    this.Hpb.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.Hpc = ((EditText)findViewById(2131298967));
    this.Hpc.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.Hpd = ((EditText)findViewById(2131305828));
    this.Hpd.setText(WXHardCoderJNI.hcDBTimeout);
    this.Hpe = ((EditText)findViewById(2131305829));
    this.Hpe.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.Hpf = ((EditText)findViewById(2131296358));
    this.Hpf.setText(WXHardCoderJNI.hcDBActionQuery);
    this.Hpg = ((EditText)findViewById(2131296359));
    this.Hpg.setText(WXHardCoderJNI.hcDBActionWrite);
    this.Hph = ((Spinner)findViewById(2131298837));
    this.Hph.setSelection(WXHardCoderJNI.hcDBCPU);
    this.Hpi = ((Spinner)findViewById(2131301103));
    this.Hpi.setSelection(WXHardCoderJNI.hcDBIO);
    this.Hpj = ((CheckBox)findViewById(2131305776));
    this.Hpj.setChecked(WXHardCoderJNI.hcDBThr);
    this.Hpk = ((CheckBox)findViewById(2131298254));
    this.Hpk.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.Hpl = ((EditText)findViewById(2131298981));
    this.Hpl.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.Hpm = ((EditText)findViewById(2131305843));
    this.Hpm.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.Hpn = ((EditText)findViewById(2131296393));
    this.Hpn.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.Hpo = ((Spinner)findViewById(2131298851));
    this.Hpo.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.Hpp = ((Spinner)findViewById(2131301117));
    this.Hpp.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.Hpq = ((CheckBox)findViewById(2131305790));
    this.Hpq.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.Hpr = ((CheckBox)findViewById(2131298224));
    this.Hpr.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.Hps = ((EditText)findViewById(2131298968));
    this.Hps.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.Hpt = ((EditText)findViewById(2131305830));
    this.Hpt.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.Hpu = ((EditText)findViewById(2131296360));
    this.Hpu.setText(WXHardCoderJNI.hcDecodePicAction);
    this.Hpv = ((Spinner)findViewById(2131298838));
    this.Hpv.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.Hpw = ((Spinner)findViewById(2131301104));
    this.Hpw.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.Hpx = ((CheckBox)findViewById(2131305777));
    this.Hpx.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.Hpy = ((CheckBox)findViewById(2131298227));
    this.Hpy.setChecked(WXHardCoderJNI.hcGifEnable);
    this.Hpz = ((EditText)findViewById(2131298970));
    this.Hpz.setText(WXHardCoderJNI.hcGifDelay);
    this.HpA = ((EditText)findViewById(2131305832));
    this.HpA.setText(WXHardCoderJNI.hcGifTimeout);
    this.HpB = ((EditText)findViewById(2131296364));
    this.HpB.setText(WXHardCoderJNI.hcGifAction);
    this.HpC = ((Spinner)findViewById(2131298840));
    this.HpC.setSelection(WXHardCoderJNI.hcGifCPU);
    this.HpD = ((Spinner)findViewById(2131301106));
    this.HpD.setSelection(WXHardCoderJNI.hcGifIO);
    this.HpE = ((CheckBox)findViewById(2131305779));
    this.HpE.setChecked(WXHardCoderJNI.hcGifThr);
    this.HpF = ((CheckBox)findViewById(2131298228));
    this.HpF.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.HpG = ((EditText)findViewById(2131298971));
    this.HpG.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.HpH = ((EditText)findViewById(2131305833));
    this.HpH.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.HpI = ((EditText)findViewById(2131296365));
    this.HpI.setText(WXHardCoderJNI.hcGifFrameAction);
    this.HpJ = ((Spinner)findViewById(2131298841));
    this.HpJ.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.HpK = ((Spinner)findViewById(2131301107));
    this.HpK.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.HpL = ((CheckBox)findViewById(2131305780));
    this.HpL.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.HpM = ((CheckBox)findViewById(2131298244));
    this.HpM.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.HpN = ((EditText)findViewById(2131298978));
    this.HpN.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.HpO = ((EditText)findViewById(2131305840));
    this.HpO.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.HpP = ((EditText)findViewById(2131296385));
    this.HpP.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.HpQ = ((Spinner)findViewById(2131298848));
    this.HpQ.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.HpR = ((Spinner)findViewById(2131301114));
    this.HpR.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.HpS = ((CheckBox)findViewById(2131305787));
    this.HpS.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.HpT = ((CheckBox)findViewById(2131298245));
    this.HpT.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.HpU = ((EditText)findViewById(2131298979));
    this.HpU.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.HpV = ((EditText)findViewById(2131305841));
    this.HpV.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.HpW = ((EditText)findViewById(2131296386));
    this.HpW.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.HpX = ((Spinner)findViewById(2131298849));
    this.HpX.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.HpY = ((Spinner)findViewById(2131301115));
    this.HpY.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.HpZ = ((CheckBox)findViewById(2131305788));
    this.HpZ.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.Hqa = ((CheckBox)findViewById(2131298243));
    this.Hqa.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.Hqb = ((EditText)findViewById(2131298977));
    this.Hqb.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.Hqc = ((EditText)findViewById(2131305839));
    this.Hqc.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.Hqd = ((EditText)findViewById(2131296384));
    this.Hqd.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.Hqe = ((Spinner)findViewById(2131298847));
    this.Hqe.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.Hqf = ((Spinner)findViewById(2131301113));
    this.Hqf.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.Hqg = ((CheckBox)findViewById(2131305786));
    this.Hqg.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.Hqh = ((CheckBox)findViewById(2131298231));
    this.Hqh.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.Hqi = ((EditText)findViewById(2131298972));
    this.Hqi.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.Hqj = ((EditText)findViewById(2131305834));
    this.Hqj.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.Hqk = ((EditText)findViewById(2131296368));
    this.Hqk.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.Hql = ((Spinner)findViewById(2131298842));
    this.Hql.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.Hqm = ((Spinner)findViewById(2131301108));
    this.Hqm.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.Hqn = ((CheckBox)findViewById(2131305781));
    this.Hqn.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.Hqo = ((CheckBox)findViewById(2131298216));
    this.Hqo.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.Hqp = ((EditText)findViewById(2131298963));
    this.Hqp.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.Hqq = ((EditText)findViewById(2131305825));
    this.Hqq.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.Hqr = ((EditText)findViewById(2131296342));
    this.Hqr.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.Hqs = ((Spinner)findViewById(2131298834));
    this.Hqs.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.Hqt = ((Spinner)findViewById(2131301100));
    this.Hqt.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.Hqu = ((CheckBox)findViewById(2131305773));
    this.Hqu.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.Hqv = ((CheckBox)findViewById(2131298217));
    this.Hqv.setChecked(WXHardCoderJNI.hcBizEnable);
    this.Hqw = ((EditText)findViewById(2131298964));
    this.Hqw.setText(WXHardCoderJNI.hcBizDelay);
    this.Hqx = ((EditText)findViewById(2131305826));
    this.Hqx.setText(WXHardCoderJNI.hcBizTimeout);
    this.Hqy = ((EditText)findViewById(2131296352));
    this.Hqy.setText(WXHardCoderJNI.hcBizAction);
    this.Hqz = ((Spinner)findViewById(2131298835));
    this.Hqz.setSelection(WXHardCoderJNI.hcBizCPU);
    this.HqA = ((Spinner)findViewById(2131301101));
    this.HqA.setSelection(WXHardCoderJNI.hcBizIO);
    this.HqB = ((CheckBox)findViewById(2131305774));
    this.HqB.setChecked(WXHardCoderJNI.hcBizThr);
    this.HnV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
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
    if (this.wgj)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.wgk, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.wgk, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    ad.i("HardCoderSettingUI", "save");
    if ((this.HnV.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.HnV.isChecked());
      WXHardCoderJNI.initHardCoder(a.cFF(), a.cFF(), null);
    }
    WXHardCoderJNI.setDebug(this.HnX.isChecked());
    WXHardCoderJNI.setHcEnable(this.HnV.isChecked());
    WXHardCoderJNI.hcRetryInterval = bt.getInt(this.HnW.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.HnZ.isChecked();
    WXHardCoderJNI.hcBootEnable = this.Hoc.isChecked();
    WXHardCoderJNI.hcBootDelay = bt.getInt(this.Hod.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.Hog.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.Hoh.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.Hoi.isChecked();
    WXHardCoderJNI.hcBootTimeout = bt.getInt(this.Hoe.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = bt.getLong(this.Hof.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.Hoj.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = bt.getInt(this.Hok.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.Hon.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.Hoo.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.Hop.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = bt.getInt(this.Hol.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = bt.getLong(this.Hom.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.Hoq.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = bt.getInt(this.Hor.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.Hou.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.Hov.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.How.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = bt.getInt(this.Hos.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = bt.getLong(this.Hot.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.Hox.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = bt.getInt(this.Hoy.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.HoB.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.HoC.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.HoD.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = bt.getInt(this.Hoz.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = bt.getLong(this.HoA.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.HoE.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = bt.getInt(this.HoF.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.HoI.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.HoJ.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.HoK.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = bt.getInt(this.HoG.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = bt.getLong(this.HoH.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.HoL.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = bt.getInt(this.HoM.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.HoP.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.HoQ.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.HoR.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = bt.getInt(this.HoN.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = bt.getLong(this.HoO.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.HoS.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = bt.getInt(this.HoT.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.HoW.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.HoX.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.HoY.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = bt.getInt(this.HoU.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = bt.getLong(this.HoV.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = bt.getLong(this.HoZ.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.Hpa.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = bt.getInt(this.Hpb.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = bt.getInt(this.Hpc.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.Hog.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.Hoh.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.Hoi.isChecked();
    WXHardCoderJNI.hcDBTimeout = bt.getInt(this.Hpd.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = bt.getInt(this.Hpe.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = bt.getLong(this.Hpf.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = bt.getLong(this.Hpg.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.Hpk.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = bt.getInt(this.Hpl.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.Hpo.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.Hpp.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.Hpq.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = bt.getInt(this.Hpm.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = bt.getLong(this.Hpn.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.Hpr.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = bt.getInt(this.Hps.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.Hpv.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.Hpw.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.Hpx.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = bt.getInt(this.Hpt.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = bt.getLong(this.Hpu.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.Hpy.isChecked();
    WXHardCoderJNI.hcGifDelay = bt.getInt(this.Hpz.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.HpC.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.HpD.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.HpE.isChecked();
    WXHardCoderJNI.hcGifTimeout = bt.getInt(this.HpA.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = bt.getLong(this.HpB.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.HpF.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = bt.getInt(this.HpG.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.HpJ.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.HpK.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.HpL.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = bt.getInt(this.HpH.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = bt.getLong(this.HpI.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.HpM.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = bt.getInt(this.HpN.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.HpQ.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.HpR.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.HpS.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = bt.getInt(this.HpO.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = bt.getLong(this.HpP.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.HpT.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = bt.getInt(this.HpU.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.HpX.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.HpY.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.HpZ.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = bt.getInt(this.HpV.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = bt.getLong(this.HpW.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.Hqa.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = bt.getInt(this.Hqb.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.Hqe.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.Hqf.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.Hqg.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = bt.getInt(this.Hqc.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = bt.getLong(this.Hqd.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.Hqh.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = bt.getInt(this.Hqi.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.Hql.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.Hqm.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.Hqn.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = bt.getInt(this.Hqj.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = bt.getLong(this.Hqk.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.Hqo.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = bt.getInt(this.Hqp.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.Hqs.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.Hqt.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.Hqu.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = bt.getInt(this.Hqq.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = bt.getLong(this.Hqr.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.Hqv.isChecked();
    WXHardCoderJNI.hcBizDelay = bt.getInt(this.Hqw.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.Hqz.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.HqA.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.HqB.isChecked();
    WXHardCoderJNI.hcBizTimeout = bt.getInt(this.Hqx.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = bt.getLong(this.Hqy.getText().toString(), WXHardCoderJNI.hcBizAction);
    a(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */