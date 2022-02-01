package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czi
  extends com.tencent.mm.bx.a
{
  public String ZoK;
  public String aaEA;
  public String aaEB;
  public String aaEC;
  public int aaED;
  public int aaEE;
  public String aaEF;
  public String aaEG;
  public String aaEH;
  public String aaEp;
  public czj aaEq;
  public String aaEr;
  public int aaEs;
  public int aaEt;
  public long aaEu;
  public String aaEv;
  public String aaEw;
  public int aaEx;
  public String aaEy;
  public String aaEz;
  public long aayC;
  public int nQJ;
  public int subType;
  public int user_flag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaEp != null) {
        paramVarArgs.g(1, this.aaEp);
      }
      paramVarArgs.bS(2, this.subType);
      if (this.ZoK != null) {
        paramVarArgs.g(3, this.ZoK);
      }
      if (this.aaEq != null)
      {
        paramVarArgs.qD(4, this.aaEq.computeSize());
        this.aaEq.writeFields(paramVarArgs);
      }
      if (this.aaEr != null) {
        paramVarArgs.g(5, this.aaEr);
      }
      paramVarArgs.bS(6, this.aaEs);
      paramVarArgs.bS(7, this.aaEt);
      paramVarArgs.bv(8, this.aaEu);
      paramVarArgs.bS(9, this.nQJ);
      paramVarArgs.bS(10, this.user_flag);
      if (this.aaEv != null) {
        paramVarArgs.g(11, this.aaEv);
      }
      if (this.aaEw != null) {
        paramVarArgs.g(12, this.aaEw);
      }
      paramVarArgs.bS(13, this.aaEx);
      if (this.aaEy != null) {
        paramVarArgs.g(14, this.aaEy);
      }
      if (this.aaEz != null) {
        paramVarArgs.g(15, this.aaEz);
      }
      if (this.aaEA != null) {
        paramVarArgs.g(16, this.aaEA);
      }
      if (this.aaEB != null) {
        paramVarArgs.g(17, this.aaEB);
      }
      if (this.aaEC != null) {
        paramVarArgs.g(18, this.aaEC);
      }
      paramVarArgs.bS(19, this.aaED);
      paramVarArgs.bv(20, this.aayC);
      paramVarArgs.bS(21, this.aaEE);
      if (this.aaEF != null) {
        paramVarArgs.g(22, this.aaEF);
      }
      if (this.aaEG != null) {
        paramVarArgs.g(23, this.aaEG);
      }
      if (this.aaEH != null) {
        paramVarArgs.g(24, this.aaEH);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaEp == null) {
        break label1532;
      }
    }
    label1532:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaEp) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.subType);
      paramInt = i;
      if (this.ZoK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZoK);
      }
      i = paramInt;
      if (this.aaEq != null) {
        i = paramInt + i.a.a.a.qC(4, this.aaEq.computeSize());
      }
      paramInt = i;
      if (this.aaEr != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaEr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aaEs) + i.a.a.b.b.a.cJ(7, this.aaEt) + i.a.a.b.b.a.q(8, this.aaEu) + i.a.a.b.b.a.cJ(9, this.nQJ) + i.a.a.b.b.a.cJ(10, this.user_flag);
      paramInt = i;
      if (this.aaEv != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaEv);
      }
      i = paramInt;
      if (this.aaEw != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaEw);
      }
      i += i.a.a.b.b.a.cJ(13, this.aaEx);
      paramInt = i;
      if (this.aaEy != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaEy);
      }
      i = paramInt;
      if (this.aaEz != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaEz);
      }
      paramInt = i;
      if (this.aaEA != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaEA);
      }
      i = paramInt;
      if (this.aaEB != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.aaEB);
      }
      paramInt = i;
      if (this.aaEC != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aaEC);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.aaED) + i.a.a.b.b.a.q(20, this.aayC) + i.a.a.b.b.a.cJ(21, this.aaEE);
      paramInt = i;
      if (this.aaEF != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.aaEF);
      }
      i = paramInt;
      if (this.aaEG != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.aaEG);
      }
      paramInt = i;
      if (this.aaEH != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.aaEH);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        czi localczi = (czi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localczi.aaEp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localczi.subType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localczi.ZoK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            czj localczj = new czj();
            if ((localObject != null) && (localObject.length > 0)) {
              localczj.parseFrom((byte[])localObject);
            }
            localczi.aaEq = localczj;
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localczi.aaEr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localczi.aaEs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localczi.aaEt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localczi.aaEu = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localczi.nQJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localczi.user_flag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localczi.aaEv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localczi.aaEw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localczi.aaEx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localczi.aaEy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localczi.aaEz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localczi.aaEA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localczi.aaEB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localczi.aaEC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localczi.aaED = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localczi.aayC = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localczi.aaEE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91520);
          return 0;
        case 22: 
          localczi.aaEF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 23: 
          localczi.aaEG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91520);
          return 0;
        }
        localczi.aaEH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czi
 * JD-Core Version:    0.7.0.1
 */