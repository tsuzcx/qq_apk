package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jg
  extends cpx
{
  public LinkedList<String> DWW;
  public LinkedList<cpv> DWX;
  public long DWY;
  public int DWZ;
  public int DXa;
  public String nOG;
  
  public jg()
  {
    AppMethodBeat.i(6394);
    this.DWW = new LinkedList();
    this.DWX = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.DWW);
      paramVarArgs.e(3, 8, this.DWX);
      if (this.nOG != null) {
        paramVarArgs.d(4, this.nOG);
      }
      paramVarArgs.aO(5, this.DWY);
      paramVarArgs.aR(6, this.DWZ);
      paramVarArgs.aR(7, this.DXa);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label719;
      }
    }
    label719:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.DWW) + f.a.a.a.c(3, 8, this.DWX);
      paramInt = i;
      if (this.nOG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nOG);
      }
      i = f.a.a.b.b.a.p(5, this.DWY);
      int j = f.a.a.b.b.a.bx(6, this.DWZ);
      int k = f.a.a.b.b.a.bx(7, this.DXa);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWW.clear();
        this.DWX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        jg localjg = (jg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localjg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localjg.DWW.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localjg.DWX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localjg.nOG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localjg.DWY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localjg.DWZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(6395);
          return 0;
        }
        localjg.DXa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jg
 * JD-Core Version:    0.7.0.1
 */