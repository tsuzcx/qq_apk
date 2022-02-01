package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eee
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int IcB;
  public String UID;
  public String aaMz;
  public een abja;
  public eeq abjb;
  public String abjc;
  public LinkedList<eeh> abjd;
  public float abje;
  public String abjf;
  public String abjg;
  public LinkedList<eec> abjh;
  public String abji;
  public String pSg;
  public String pSh;
  public String pSo;
  
  public eee()
  {
    AppMethodBeat.i(260113);
    this.abjd = new LinkedList();
    this.abjh = new LinkedList();
    AppMethodBeat.o(260113);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260120);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UID != null) {
        paramVarArgs.g(1, this.UID);
      }
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.abja != null)
      {
        paramVarArgs.qD(3, this.abja.computeSize());
        this.abja.writeFields(paramVarArgs);
      }
      if (this.abjb != null)
      {
        paramVarArgs.qD(4, this.abjb.computeSize());
        this.abjb.writeFields(paramVarArgs);
      }
      if (this.aaMz != null) {
        paramVarArgs.g(5, this.aaMz);
      }
      if (this.abjc != null) {
        paramVarArgs.g(6, this.abjc);
      }
      paramVarArgs.e(7, 8, this.abjd);
      paramVarArgs.l(8, this.abje);
      if (this.pSg != null) {
        paramVarArgs.g(9, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(10, this.pSh);
      }
      if (this.abjf != null) {
        paramVarArgs.g(11, this.abjf);
      }
      if (this.abjg != null) {
        paramVarArgs.g(12, this.abjg);
      }
      paramVarArgs.bS(13, this.IcB);
      if (this.pSo != null) {
        paramVarArgs.g(14, this.pSo);
      }
      paramVarArgs.e(15, 8, this.abjh);
      if (this.abji != null) {
        paramVarArgs.g(101, this.abji);
      }
      AppMethodBeat.o(260120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UID == null) {
        break label1421;
      }
    }
    label1421:
    for (int i = i.a.a.b.b.a.h(1, this.UID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.abja != null) {
        i = paramInt + i.a.a.a.qC(3, this.abja.computeSize());
      }
      paramInt = i;
      if (this.abjb != null) {
        paramInt = i + i.a.a.a.qC(4, this.abjb.computeSize());
      }
      i = paramInt;
      if (this.aaMz != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaMz);
      }
      paramInt = i;
      if (this.abjc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abjc);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.abjd) + (i.a.a.b.b.a.ko(8) + 4);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.pSh);
      }
      paramInt = i;
      if (this.abjf != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abjf);
      }
      i = paramInt;
      if (this.abjg != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abjg);
      }
      i += i.a.a.b.b.a.cJ(13, this.IcB);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.pSo);
      }
      i = paramInt + i.a.a.a.c(15, 8, this.abjh);
      paramInt = i;
      if (this.abji != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.abji);
      }
      AppMethodBeat.o(260120);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjd.clear();
        this.abjh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260120);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eee localeee = (eee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260120);
          return -1;
        case 1: 
          localeee.UID = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 2: 
          localeee.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new een();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((een)localObject2).parseFrom((byte[])localObject1);
            }
            localeee.abja = ((een)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260120);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eeq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eeq)localObject2).parseFrom((byte[])localObject1);
            }
            localeee.abjb = ((eeq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260120);
          return 0;
        case 5: 
          localeee.aaMz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 6: 
          localeee.abjc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eeh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eeh)localObject2).parseFrom((byte[])localObject1);
            }
            localeee.abjd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260120);
          return 0;
        case 8: 
          localeee.abje = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260120);
          return 0;
        case 9: 
          localeee.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 10: 
          localeee.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 11: 
          localeee.abjf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 12: 
          localeee.abjg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 13: 
          localeee.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260120);
          return 0;
        case 14: 
          localeee.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260120);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eec();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eec)localObject2).parseFrom((byte[])localObject1);
            }
            localeee.abjh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260120);
          return 0;
        }
        localeee.abji = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260120);
        return 0;
      }
      AppMethodBeat.o(260120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eee
 * JD-Core Version:    0.7.0.1
 */