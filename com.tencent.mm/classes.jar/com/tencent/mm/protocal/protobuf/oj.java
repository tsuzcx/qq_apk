package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oj
  extends dop
{
  public LinkedList<os> KUf;
  public int KUg;
  public int KUh;
  public String KUi;
  public long KUj;
  public String KUk;
  public uc KUl;
  public oi KUm;
  public fq KUn;
  public String KUo;
  public String KUp;
  public LinkedList<dli> gCs;
  
  public oj()
  {
    AppMethodBeat.i(212238);
    this.KUf = new LinkedList();
    this.gCs = new LinkedList();
    AppMethodBeat.o(212238);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212239);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KUf);
      paramVarArgs.aM(3, this.KUg);
      paramVarArgs.aM(4, this.KUh);
      if (this.KUi != null) {
        paramVarArgs.e(5, this.KUi);
      }
      paramVarArgs.bb(6, this.KUj);
      if (this.KUk != null) {
        paramVarArgs.e(7, this.KUk);
      }
      if (this.KUl != null)
      {
        paramVarArgs.ni(8, this.KUl.computeSize());
        this.KUl.writeFields(paramVarArgs);
      }
      if (this.KUm != null)
      {
        paramVarArgs.ni(9, this.KUm.computeSize());
        this.KUm.writeFields(paramVarArgs);
      }
      if (this.KUn != null)
      {
        paramVarArgs.ni(10, this.KUn.computeSize());
        this.KUn.writeFields(paramVarArgs);
      }
      if (this.KUo != null) {
        paramVarArgs.e(11, this.KUo);
      }
      if (this.KUp != null) {
        paramVarArgs.e(12, this.KUp);
      }
      paramVarArgs.e(13, 8, this.gCs);
      AppMethodBeat.o(212239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1438;
      }
    }
    label1438:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KUf) + g.a.a.b.b.a.bu(3, this.KUg) + g.a.a.b.b.a.bu(4, this.KUh);
      paramInt = i;
      if (this.KUi != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KUi);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.KUj);
      paramInt = i;
      if (this.KUk != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KUk);
      }
      i = paramInt;
      if (this.KUl != null) {
        i = paramInt + g.a.a.a.nh(8, this.KUl.computeSize());
      }
      paramInt = i;
      if (this.KUm != null) {
        paramInt = i + g.a.a.a.nh(9, this.KUm.computeSize());
      }
      i = paramInt;
      if (this.KUn != null) {
        i = paramInt + g.a.a.a.nh(10, this.KUn.computeSize());
      }
      paramInt = i;
      if (this.KUo != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KUo);
      }
      i = paramInt;
      if (this.KUp != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KUp);
      }
      paramInt = g.a.a.a.c(13, 8, this.gCs);
      AppMethodBeat.o(212239);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUf.clear();
        this.gCs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212239);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oj localoj = (oj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212239);
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
            localoj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212239);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new os();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((os)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoj.KUf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212239);
          return 0;
        case 3: 
          localoj.KUg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212239);
          return 0;
        case 4: 
          localoj.KUh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212239);
          return 0;
        case 5: 
          localoj.KUi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212239);
          return 0;
        case 6: 
          localoj.KUj = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212239);
          return 0;
        case 7: 
          localoj.KUk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212239);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoj.KUl = ((uc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212239);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoj.KUm = ((oi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212239);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoj.KUn = ((fq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212239);
          return 0;
        case 11: 
          localoj.KUo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212239);
          return 0;
        case 12: 
          localoj.KUp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212239);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dli();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dli)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localoj.gCs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212239);
        return 0;
      }
      AppMethodBeat.o(212239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oj
 * JD-Core Version:    0.7.0.1
 */