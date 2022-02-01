package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afm
  extends cld
{
  public LinkedList<bkm> CUw;
  public ccl Dfn;
  public String Dfo;
  public String Dfp;
  public String Dfq;
  public String Dfr;
  public float Dfs;
  public String Dft;
  public int pNP;
  public String pNQ;
  
  public afm()
  {
    AppMethodBeat.i(104361);
    this.CUw = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CUw);
      if (this.Dfn != null)
      {
        paramVarArgs.kX(3, this.Dfn.computeSize());
        this.Dfn.writeFields(paramVarArgs);
      }
      if (this.Dfo != null) {
        paramVarArgs.d(4, this.Dfo);
      }
      if (this.Dfp != null) {
        paramVarArgs.d(5, this.Dfp);
      }
      if (this.Dfq != null) {
        paramVarArgs.d(6, this.Dfq);
      }
      if (this.Dfr != null) {
        paramVarArgs.d(7, this.Dfr);
      }
      paramVarArgs.x(8, this.Dfs);
      paramVarArgs.aR(9, this.pNP);
      if (this.pNQ != null) {
        paramVarArgs.d(10, this.pNQ);
      }
      if (this.Dft != null) {
        paramVarArgs.d(11, this.Dft);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1113;
      }
    }
    label1113:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.CUw);
      paramInt = i;
      if (this.Dfn != null) {
        paramInt = i + f.a.a.a.kW(3, this.Dfn.computeSize());
      }
      i = paramInt;
      if (this.Dfo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Dfo);
      }
      paramInt = i;
      if (this.Dfp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Dfp);
      }
      i = paramInt;
      if (this.Dfq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Dfq);
      }
      paramInt = i;
      if (this.Dfr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dfr);
      }
      i = paramInt + (f.a.a.b.b.a.fY(8) + 4) + f.a.a.b.b.a.bA(9, this.pNP);
      paramInt = i;
      if (this.pNQ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pNQ);
      }
      i = paramInt;
      if (this.Dft != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Dft);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CUw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afm localafm = (afm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.CUw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafm.Dfn = ((ccl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localafm.Dfo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localafm.Dfp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localafm.Dfq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localafm.Dfr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localafm.Dfs = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localafm.pNP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localafm.pNQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localafm.Dft = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afm
 * JD-Core Version:    0.7.0.1
 */