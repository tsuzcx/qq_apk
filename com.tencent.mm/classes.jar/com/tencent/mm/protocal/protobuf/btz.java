package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btz
  extends cvw
{
  public int GWF;
  public boolean GZm;
  public boolean GZn;
  public ehk HgZ;
  public ejh Hha;
  public eij Hhb;
  public ekg Hhc;
  public eja Hhd;
  public eji Hhe;
  public int Hhf;
  public String Hhg;
  public String Hhh;
  public ejj Hhi;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.HgZ != null)
      {
        paramVarArgs.lJ(3, this.HgZ.computeSize());
        this.HgZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GWF);
      if (this.Hha != null)
      {
        paramVarArgs.lJ(5, this.Hha.computeSize());
        this.Hha.writeFields(paramVarArgs);
      }
      if (this.Hhb != null)
      {
        paramVarArgs.lJ(6, this.Hhb.computeSize());
        this.Hhb.writeFields(paramVarArgs);
      }
      if (this.Hhc != null)
      {
        paramVarArgs.lJ(7, this.Hhc.computeSize());
        this.Hhc.writeFields(paramVarArgs);
      }
      if (this.Hhd != null)
      {
        paramVarArgs.lJ(8, this.Hhd.computeSize());
        this.Hhd.writeFields(paramVarArgs);
      }
      if (this.Hhe != null)
      {
        paramVarArgs.lJ(9, this.Hhe.computeSize());
        this.Hhe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.Hhf);
      if (this.Hhg != null) {
        paramVarArgs.d(11, this.Hhg);
      }
      if (this.Hhh != null) {
        paramVarArgs.d(12, this.Hhh);
      }
      paramVarArgs.bC(13, this.GZm);
      paramVarArgs.bC(14, this.GZn);
      if (this.Hhi != null)
      {
        paramVarArgs.lJ(15, this.Hhi.computeSize());
        this.Hhi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1754;
      }
    }
    label1754:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.HgZ != null) {
        i = paramInt + f.a.a.a.lI(3, this.HgZ.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.GWF);
      paramInt = i;
      if (this.Hha != null) {
        paramInt = i + f.a.a.a.lI(5, this.Hha.computeSize());
      }
      i = paramInt;
      if (this.Hhb != null) {
        i = paramInt + f.a.a.a.lI(6, this.Hhb.computeSize());
      }
      paramInt = i;
      if (this.Hhc != null) {
        paramInt = i + f.a.a.a.lI(7, this.Hhc.computeSize());
      }
      i = paramInt;
      if (this.Hhd != null) {
        i = paramInt + f.a.a.a.lI(8, this.Hhd.computeSize());
      }
      paramInt = i;
      if (this.Hhe != null) {
        paramInt = i + f.a.a.a.lI(9, this.Hhe.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.Hhf);
      paramInt = i;
      if (this.Hhg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hhg);
      }
      i = paramInt;
      if (this.Hhh != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Hhh);
      }
      i = i + f.a.a.b.b.a.amF(13) + f.a.a.b.b.a.amF(14);
      paramInt = i;
      if (this.Hhi != null) {
        paramInt = i + f.a.a.a.lI(15, this.Hhi.computeSize());
      }
      AppMethodBeat.o(123624);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btz localbtz = (btz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localbtz.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.HgZ = ((ehk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localbtz.GWF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Hha = ((ejh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Hhb = ((eij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Hhc = ((ekg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Hhd = ((eja)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Hhe = ((eji)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localbtz.Hhf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localbtz.Hhg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localbtz.Hhh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localbtz.GZm = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localbtz.GZn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123624);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtz.Hhi = ((ejj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btz
 * JD-Core Version:    0.7.0.1
 */