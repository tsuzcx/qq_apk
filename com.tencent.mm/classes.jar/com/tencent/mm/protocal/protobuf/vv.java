package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vv
  extends cpx
{
  public String Eqh;
  public LinkedList<cyb> Eqi;
  public LinkedList<cyd> Eqj;
  public LinkedList<cya> Eqk;
  public LinkedList<cxz> Eql;
  public LinkedList<cyc> Eqm;
  public int ndI;
  
  public vv()
  {
    AppMethodBeat.i(32163);
    this.Eqi = new LinkedList();
    this.Eqj = new LinkedList();
    this.Eqk = new LinkedList();
    this.Eql = new LinkedList();
    this.Eqm = new LinkedList();
    AppMethodBeat.o(32163);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32164);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      if (this.Eqh != null) {
        paramVarArgs.d(3, this.Eqh);
      }
      paramVarArgs.e(4, 8, this.Eqi);
      paramVarArgs.e(5, 8, this.Eqj);
      paramVarArgs.e(6, 8, this.Eqk);
      paramVarArgs.e(7, 8, this.Eql);
      paramVarArgs.e(8, 8, this.Eqm);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.Eqh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Eqh);
      }
      i = f.a.a.a.c(4, 8, this.Eqi);
      int j = f.a.a.a.c(5, 8, this.Eqj);
      int k = f.a.a.a.c(6, 8, this.Eqk);
      int m = f.a.a.a.c(7, 8, this.Eql);
      int n = f.a.a.a.c(8, 8, this.Eqm);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eqi.clear();
        this.Eqj.clear();
        this.Eqk.clear();
        this.Eql.clear();
        this.Eqm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vv localvv = (vv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
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
            localvv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localvv.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localvv.Eqh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvv.Eqi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvv.Eqj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvv.Eqk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvv.Eql.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localvv.Eqm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      AppMethodBeat.o(32164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */