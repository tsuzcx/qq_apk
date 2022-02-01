package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjg
  extends cqk
{
  public String BsL;
  public cfz DXV;
  public String Fxf;
  public LinkedList<ik> Fxg;
  public int nWx;
  public String nWy;
  
  public cjg()
  {
    AppMethodBeat.i(72553);
    this.Fxg = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.Fxf != null) {
        paramVarArgs.d(4, this.Fxf);
      }
      paramVarArgs.e(5, 8, this.Fxg);
      if (this.DXV != null)
      {
        paramVarArgs.ln(6, this.DXV.computeSize());
        this.DXV.writeFields(paramVarArgs);
      }
      if (this.BsL != null) {
        paramVarArgs.d(7, this.BsL);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Fxf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fxf);
      }
      i += f.a.a.a.c(5, 8, this.Fxg);
      paramInt = i;
      if (this.DXV != null) {
        paramInt = i + f.a.a.a.lm(6, this.DXV.computeSize());
      }
      i = paramInt;
      if (this.BsL != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.BsL);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fxg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjg localcjg = (cjg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localcjg.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localcjg.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localcjg.Fxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ik();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjg.Fxg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjg.DXV = ((cfz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localcjg.BsL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjg
 * JD-Core Version:    0.7.0.1
 */