package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dio
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public boolean YLD;
  public String ZRm;
  public int ZWw;
  public boolean ZlV;
  public String Zqd;
  public int aaNk;
  public LinkedList<String> aaNl;
  public boolean aaNm;
  public String aaNn;
  public String aaNo;
  public String aaNp;
  public String aaNq;
  public int aaNr;
  public zf aaNs;
  public int aaun;
  public int end_time;
  public long mMJ;
  public int status;
  
  public dio()
  {
    AppMethodBeat.i(260216);
    this.aaNl = new LinkedList();
    AppMethodBeat.o(260216);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260225);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mMJ);
      if (this.Zqd != null) {
        paramVarArgs.g(2, this.Zqd);
      }
      paramVarArgs.bS(3, this.HTK);
      paramVarArgs.bS(4, this.end_time);
      paramVarArgs.bS(5, this.status);
      paramVarArgs.bS(6, this.ZWw);
      paramVarArgs.bS(7, this.aaNk);
      paramVarArgs.bS(8, this.aaun);
      if (this.ZRm != null) {
        paramVarArgs.g(9, this.ZRm);
      }
      paramVarArgs.e(10, 1, this.aaNl);
      paramVarArgs.di(11, this.YLD);
      paramVarArgs.di(12, this.ZlV);
      paramVarArgs.di(13, this.aaNm);
      if (this.aaNn != null) {
        paramVarArgs.g(14, this.aaNn);
      }
      if (this.aaNo != null) {
        paramVarArgs.g(15, this.aaNo);
      }
      if (this.aaNp != null) {
        paramVarArgs.g(16, this.aaNp);
      }
      if (this.aaNq != null) {
        paramVarArgs.g(17, this.aaNq);
      }
      paramVarArgs.bS(18, this.aaNr);
      if (this.aaNs != null)
      {
        paramVarArgs.qD(19, this.aaNs.computeSize());
        this.aaNs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260225);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.mMJ) + 0;
      paramInt = i;
      if (this.Zqd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zqd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.HTK) + i.a.a.b.b.a.cJ(4, this.end_time) + i.a.a.b.b.a.cJ(5, this.status) + i.a.a.b.b.a.cJ(6, this.ZWw) + i.a.a.b.b.a.cJ(7, this.aaNk) + i.a.a.b.b.a.cJ(8, this.aaun);
      paramInt = i;
      if (this.ZRm != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZRm);
      }
      i = paramInt + i.a.a.a.c(10, 1, this.aaNl) + (i.a.a.b.b.a.ko(11) + 1) + (i.a.a.b.b.a.ko(12) + 1) + (i.a.a.b.b.a.ko(13) + 1);
      paramInt = i;
      if (this.aaNn != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaNn);
      }
      i = paramInt;
      if (this.aaNo != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaNo);
      }
      paramInt = i;
      if (this.aaNp != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaNp);
      }
      i = paramInt;
      if (this.aaNq != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.aaNq);
      }
      i += i.a.a.b.b.a.cJ(18, this.aaNr);
      paramInt = i;
      if (this.aaNs != null) {
        paramInt = i + i.a.a.a.qC(19, this.aaNs.computeSize());
      }
      AppMethodBeat.o(260225);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaNl.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260225);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dio localdio = (dio)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260225);
        return -1;
      case 1: 
        localdio.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(260225);
        return 0;
      case 2: 
        localdio.Zqd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 3: 
        localdio.HTK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 4: 
        localdio.end_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 5: 
        localdio.status = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 6: 
        localdio.ZWw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 7: 
        localdio.aaNk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 8: 
        localdio.aaun = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      case 9: 
        localdio.ZRm = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 10: 
        localdio.aaNl.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(260225);
        return 0;
      case 11: 
        localdio.YLD = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(260225);
        return 0;
      case 12: 
        localdio.ZlV = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(260225);
        return 0;
      case 13: 
        localdio.aaNm = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(260225);
        return 0;
      case 14: 
        localdio.aaNn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 15: 
        localdio.aaNo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 16: 
        localdio.aaNp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 17: 
        localdio.aaNq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260225);
        return 0;
      case 18: 
        localdio.aaNr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260225);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        zf localzf = new zf();
        if ((localObject != null) && (localObject.length > 0)) {
          localzf.parseFrom((byte[])localObject);
        }
        localdio.aaNs = localzf;
        paramInt += 1;
      }
      AppMethodBeat.o(260225);
      return 0;
    }
    AppMethodBeat.o(260225);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */