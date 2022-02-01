package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class eqd
  extends dop
{
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t KLQ;
  public int KMz;
  public String MbK;
  public int NnF;
  public LinkedList<eqa> NnG;
  public int NnH;
  public LinkedList<Integer> NnI;
  public int NnJ;
  public LinkedList<eqc> NnK;
  public int NnL;
  
  public eqd()
  {
    AppMethodBeat.i(152726);
    this.NnG = new LinkedList();
    this.NnI = new LinkedList();
    this.NnK = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KMz);
      paramVarArgs.aM(3, this.NnF);
      paramVarArgs.e(4, 8, this.NnG);
      if (this.MbK != null) {
        paramVarArgs.e(5, this.MbK);
      }
      paramVarArgs.aM(6, this.NnH);
      paramVarArgs.f(7, 2, this.NnI);
      paramVarArgs.aM(8, this.NnJ);
      paramVarArgs.e(9, 8, this.NnK);
      if (this.KLP != null)
      {
        paramVarArgs.ni(10, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(11, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.NnL);
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.NnF) + g.a.a.a.c(4, 8, this.NnG);
      paramInt = i;
      if (this.MbK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MbK);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NnH) + g.a.a.a.d(7, 2, this.NnI) + g.a.a.b.b.a.bu(8, this.NnJ) + g.a.a.a.c(9, 8, this.NnK);
      paramInt = i;
      if (this.KLP != null) {
        paramInt = i + g.a.a.a.nh(10, this.KLP.computeSize());
      }
      i = paramInt;
      if (this.KLQ != null) {
        i = paramInt + g.a.a.a.nh(11, this.KLQ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(12, this.NnL);
      AppMethodBeat.o(152727);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NnG.clear();
        this.NnI.clear();
        this.NnK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqd localeqd = (eqd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localeqd.KMz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localeqd.NnF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqd.NnG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localeqd.MbK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localeqd.NnH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localeqd.NnI = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localeqd.NnJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqd.NnK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqd.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeqd.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        }
        localeqd.NnL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqd
 * JD-Core Version:    0.7.0.1
 */