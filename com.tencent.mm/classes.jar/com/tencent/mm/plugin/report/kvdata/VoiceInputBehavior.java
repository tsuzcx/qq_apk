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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.cancel);
      paramVarArgs.bS(2, this.send);
      paramVarArgs.bS(3, this.click);
      paramVarArgs.bS(4, this.longClick);
      paramVarArgs.bv(5, this.longClickTime);
      paramVarArgs.bS(6, this.textClick);
      paramVarArgs.bS(7, this.textChangeCount);
      paramVarArgs.bv(8, this.textChangeTime);
      paramVarArgs.bS(9, this.textChangeReturn);
      paramVarArgs.bv(10, this.voiceInputTime);
      paramVarArgs.bS(11, this.fail);
      paramVarArgs.bS(12, this.clear);
      paramVarArgs.bS(13, this.smileIconClick);
      paramVarArgs.bS(14, this.voiceIconClick);
      paramVarArgs.bS(15, this.fullScreenVoiceLongClick);
      paramVarArgs.bv(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.bS(17, this.showInit);
      paramVarArgs.bv(18, this.initChoose);
      paramVarArgs.bS(19, this.chooseArea);
      paramVarArgs.bS(20, this.chooseCantonese);
      paramVarArgs.bS(21, this.setlanguage);
      paramVarArgs.bS(22, this.setSwitchCantonese);
      paramVarArgs.bS(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.cancel);
      int i = i.a.a.b.b.a.cJ(2, this.send);
      int j = i.a.a.b.b.a.cJ(3, this.click);
      int k = i.a.a.b.b.a.cJ(4, this.longClick);
      int m = i.a.a.b.b.a.q(5, this.longClickTime);
      int n = i.a.a.b.b.a.cJ(6, this.textClick);
      int i1 = i.a.a.b.b.a.cJ(7, this.textChangeCount);
      int i2 = i.a.a.b.b.a.q(8, this.textChangeTime);
      int i3 = i.a.a.b.b.a.cJ(9, this.textChangeReturn);
      int i4 = i.a.a.b.b.a.q(10, this.voiceInputTime);
      int i5 = i.a.a.b.b.a.cJ(11, this.fail);
      int i6 = i.a.a.b.b.a.cJ(12, this.clear);
      int i7 = i.a.a.b.b.a.cJ(13, this.smileIconClick);
      int i8 = i.a.a.b.b.a.cJ(14, this.voiceIconClick);
      int i9 = i.a.a.b.b.a.cJ(15, this.fullScreenVoiceLongClick);
      int i10 = i.a.a.b.b.a.q(16, this.fullScreenVoiceLongClickTime);
      int i11 = i.a.a.b.b.a.cJ(17, this.showInit);
      int i12 = i.a.a.b.b.a.q(18, this.initChoose);
      int i13 = i.a.a.b.b.a.cJ(19, this.chooseArea);
      int i14 = i.a.a.b.b.a.cJ(20, this.chooseCantonese);
      int i15 = i.a.a.b.b.a.cJ(21, this.setlanguage);
      int i16 = i.a.a.b.b.a.cJ(22, this.setSwitchCantonese);
      int i17 = i.a.a.b.b.a.cJ(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151541);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.ajGk.aaw();
        AppMethodBeat.o(151541);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.ajGk.aaw();
        AppMethodBeat.o(151541);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.ajGk.aaw();
        AppMethodBeat.o(151541);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.ajGk.aaw();
        AppMethodBeat.o(151541);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.ajGk.aaw();
        AppMethodBeat.o(151541);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.ajGk.aar();
        AppMethodBeat.o(151541);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.ajGk.aar();
      AppMethodBeat.o(151541);
      return 0;
    }
    AppMethodBeat.o(151541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */