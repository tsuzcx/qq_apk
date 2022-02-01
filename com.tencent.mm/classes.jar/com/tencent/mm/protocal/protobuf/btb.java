package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btb
  extends dpc
{
  public dux LZD;
  public fdd LZE;
  public fdv LZF;
  public anu LZG;
  public fdf LZH;
  public fef LZI;
  public feh LZJ;
  public String LZK;
  public String LZL;
  public LinkedList<feh> LZM;
  
  public btb()
  {
    AppMethodBeat.i(194401);
    this.LZM = new LinkedList();
    AppMethodBeat.o(194401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LZD != null)
      {
        paramVarArgs.ni(2, this.LZD.computeSize());
        this.LZD.writeFields(paramVarArgs);
      }
      if (this.LZE != null)
      {
        paramVarArgs.ni(3, this.LZE.computeSize());
        this.LZE.writeFields(paramVarArgs);
      }
      if (this.LZF != null)
      {
        paramVarArgs.ni(4, this.LZF.computeSize());
        this.LZF.writeFields(paramVarArgs);
      }
      if (this.LZG != null)
      {
        paramVarArgs.ni(5, this.LZG.computeSize());
        this.LZG.writeFields(paramVarArgs);
      }
      if (this.LZH != null)
      {
        paramVarArgs.ni(6, this.LZH.computeSize());
        this.LZH.writeFields(paramVarArgs);
      }
      if (this.LZI != null)
      {
        paramVarArgs.ni(7, this.LZI.computeSize());
        this.LZI.writeFields(paramVarArgs);
      }
      if (this.LZJ != null)
      {
        paramVarArgs.ni(8, this.LZJ.computeSize());
        this.LZJ.writeFields(paramVarArgs);
      }
      if (this.LZK != null) {
        paramVarArgs.e(10, this.LZK);
      }
      if (this.LZL != null) {
        paramVarArgs.e(11, this.LZL);
      }
      paramVarArgs.e(12, 8, this.LZM);
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1714;
      }
    }
    label1714:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LZD != null) {
        paramInt = i + g.a.a.a.nh(2, this.LZD.computeSize());
      }
      i = paramInt;
      if (this.LZE != null) {
        i = paramInt + g.a.a.a.nh(3, this.LZE.computeSize());
      }
      paramInt = i;
      if (this.LZF != null) {
        paramInt = i + g.a.a.a.nh(4, this.LZF.computeSize());
      }
      i = paramInt;
      if (this.LZG != null) {
        i = paramInt + g.a.a.a.nh(5, this.LZG.computeSize());
      }
      paramInt = i;
      if (this.LZH != null) {
        paramInt = i + g.a.a.a.nh(6, this.LZH.computeSize());
      }
      i = paramInt;
      if (this.LZI != null) {
        i = paramInt + g.a.a.a.nh(7, this.LZI.computeSize());
      }
      paramInt = i;
      if (this.LZJ != null) {
        paramInt = i + g.a.a.a.nh(8, this.LZJ.computeSize());
      }
      i = paramInt;
      if (this.LZK != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LZK);
      }
      paramInt = i;
      if (this.LZL != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LZL);
      }
      i = g.a.a.a.c(12, 8, this.LZM);
      AppMethodBeat.o(153276);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LZM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btb localbtb = (btb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(153276);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dux();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dux)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZD = ((dux)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZE = ((fdd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZF = ((fdv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZG = ((anu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZH = ((fdf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fef();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fef)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZI = ((fef)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new feh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((feh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtb.LZJ = ((feh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 10: 
          localbtb.LZK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153276);
          return 0;
        case 11: 
          localbtb.LZL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153276);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new feh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((feh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbtb.LZM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btb
 * JD-Core Version:    0.7.0.1
 */