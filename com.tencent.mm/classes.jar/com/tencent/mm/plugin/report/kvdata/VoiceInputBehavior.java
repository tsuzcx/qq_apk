package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputBehavior
  extends com.tencent.mm.bx.a
{
  public int cancel;
  public int chooseArea;
  public int chooseCantonese;
  public int clear;
  public int click;
  public int fail;
  public int fullScreenVoiceLongClick;
  public long fullScreenVoiceLongClickTime;
  public long initChoose;
  public int longClick;
  public long longClickTime;
  public int send;
  public int setDefaultLanguage;
  public int setSwitchCantonese;
  public int setlanguage;
  public int showInit;
  public int smileIconClick;
  public int textChangeCount;
  public int textChangeReturn;
  public long textChangeTime;
  public int textClick;
  public int voiceIconClick;
  public long voiceInputTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.cancel);
      paramVarArgs.aS(2, this.send);
      paramVarArgs.aS(3, this.click);
      paramVarArgs.aS(4, this.longClick);
      paramVarArgs.aY(5, this.longClickTime);
      paramVarArgs.aS(6, this.textClick);
      paramVarArgs.aS(7, this.textChangeCount);
      paramVarArgs.aY(8, this.textChangeTime);
      paramVarArgs.aS(9, this.textChangeReturn);
      paramVarArgs.aY(10, this.voiceInputTime);
      paramVarArgs.aS(11, this.fail);
      paramVarArgs.aS(12, this.clear);
      paramVarArgs.aS(13, this.smileIconClick);
      paramVarArgs.aS(14, this.voiceIconClick);
      paramVarArgs.aS(15, this.fullScreenVoiceLongClick);
      paramVarArgs.aY(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.aS(17, this.showInit);
      paramVarArgs.aY(18, this.initChoose);
      paramVarArgs.aS(19, this.chooseArea);
      paramVarArgs.aS(20, this.chooseCantonese);
      paramVarArgs.aS(21, this.setlanguage);
      paramVarArgs.aS(22, this.setSwitchCantonese);
      paramVarArgs.aS(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.cancel);
      int i = f.a.a.b.b.a.bz(2, this.send);
      int j = f.a.a.b.b.a.bz(3, this.click);
      int k = f.a.a.b.b.a.bz(4, this.longClick);
      int m = f.a.a.b.b.a.p(5, this.longClickTime);
      int n = f.a.a.b.b.a.bz(6, this.textClick);
      int i1 = f.a.a.b.b.a.bz(7, this.textChangeCount);
      int i2 = f.a.a.b.b.a.p(8, this.textChangeTime);
      int i3 = f.a.a.b.b.a.bz(9, this.textChangeReturn);
      int i4 = f.a.a.b.b.a.p(10, this.voiceInputTime);
      int i5 = f.a.a.b.b.a.bz(11, this.fail);
      int i6 = f.a.a.b.b.a.bz(12, this.clear);
      int i7 = f.a.a.b.b.a.bz(13, this.smileIconClick);
      int i8 = f.a.a.b.b.a.bz(14, this.voiceIconClick);
      int i9 = f.a.a.b.b.a.bz(15, this.fullScreenVoiceLongClick);
      int i10 = f.a.a.b.b.a.p(16, this.fullScreenVoiceLongClickTime);
      int i11 = f.a.a.b.b.a.bz(17, this.showInit);
      int i12 = f.a.a.b.b.a.p(18, this.initChoose);
      int i13 = f.a.a.b.b.a.bz(19, this.chooseArea);
      int i14 = f.a.a.b.b.a.bz(20, this.chooseCantonese);
      int i15 = f.a.a.b.b.a.bz(21, this.setlanguage);
      int i16 = f.a.a.b.b.a.bz(22, this.setSwitchCantonese);
      int i17 = f.a.a.b.b.a.bz(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151541);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.NPN.zd();
        AppMethodBeat.o(151541);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.NPN.zd();
        AppMethodBeat.o(151541);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.NPN.zd();
        AppMethodBeat.o(151541);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.NPN.zd();
        AppMethodBeat.o(151541);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.NPN.zd();
        AppMethodBeat.o(151541);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.NPN.zc();
        AppMethodBeat.o(151541);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.NPN.zc();
      AppMethodBeat.o(151541);
      return 0;
    }
    AppMethodBeat.o(151541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */