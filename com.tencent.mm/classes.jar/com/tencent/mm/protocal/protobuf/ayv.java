package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayv
  extends cpx
{
  public int DUY;
  public String EJp;
  public SKBuiltinBuffer_t EQj;
  public int EQk;
  public int EQl;
  public LinkedList<cfl> EQm;
  public int EQn;
  public boz Euj;
  public int Scene;
  
  public ayv()
  {
    AppMethodBeat.i(32249);
    this.EQm = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Euj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DUY);
      paramVarArgs.aR(3, this.Scene);
      if (this.EQj != null)
      {
        paramVarArgs.ln(4, this.EQj.computeSize());
        this.EQj.writeFields(paramVarArgs);
      }
      if (this.Euj != null)
      {
        paramVarArgs.ln(5, this.Euj.computeSize());
        this.Euj.writeFields(paramVarArgs);
      }
      if (this.EJp != null) {
        paramVarArgs.d(6, this.EJp);
      }
      paramVarArgs.aR(7, this.EQk);
      paramVarArgs.aR(8, this.EQl);
      paramVarArgs.e(11, 8, this.EQm);
      paramVarArgs.aR(12, this.EQn);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DUY) + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.EQj != null) {
        paramInt = i + f.a.a.a.lm(4, this.EQj.computeSize());
      }
      i = paramInt;
      if (this.Euj != null) {
        i = paramInt + f.a.a.a.lm(5, this.Euj.computeSize());
      }
      paramInt = i;
      if (this.EJp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EJp);
      }
      i = f.a.a.b.b.a.bx(7, this.EQk);
      int j = f.a.a.b.b.a.bx(8, this.EQl);
      int k = f.a.a.a.c(11, 8, this.EQm);
      int m = f.a.a.b.b.a.bx(12, this.EQn);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EQm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Euj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayv localayv = (ayv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localayv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localayv.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localayv.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayv.EQj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayv.Euj = ((boz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localayv.EJp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localayv.EQk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localayv.EQl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayv.EQm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localayv.EQn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayv
 * JD-Core Version:    0.7.0.1
 */