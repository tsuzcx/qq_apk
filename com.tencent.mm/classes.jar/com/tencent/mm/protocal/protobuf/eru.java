package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eru
  extends dop
{
  public long Lnw;
  public String NoW;
  public String NoX;
  public LinkedList<esc> Npl;
  public esc Npm;
  public LinkedList<erw> Npn;
  
  public eru()
  {
    AppMethodBeat.i(239529);
    this.Npn = new LinkedList();
    this.Npl = new LinkedList();
    AppMethodBeat.o(239529);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NoW != null) {
        paramVarArgs.e(2, this.NoW);
      }
      if (this.Npm != null)
      {
        paramVarArgs.ni(3, this.Npm.computeSize());
        this.Npm.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(4, this.Lnw);
      if (this.NoX != null) {
        paramVarArgs.e(5, this.NoX);
      }
      paramVarArgs.e(6, 8, this.Npn);
      paramVarArgs.e(7, 8, this.Npl);
      AppMethodBeat.o(239530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NoW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NoW);
      }
      i = paramInt;
      if (this.Npm != null) {
        i = paramInt + g.a.a.a.nh(3, this.Npm.computeSize());
      }
      i += g.a.a.b.b.a.r(4, this.Lnw);
      paramInt = i;
      if (this.NoX != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.NoX);
      }
      i = g.a.a.a.c(6, 8, this.Npn);
      int j = g.a.a.a.c(7, 8, this.Npl);
      AppMethodBeat.o(239530);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Npn.clear();
        this.Npl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(239530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eru localeru = (eru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239530);
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
            localeru.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239530);
          return 0;
        case 2: 
          localeru.NoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239530);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeru.Npm = ((esc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239530);
          return 0;
        case 4: 
          localeru.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(239530);
          return 0;
        case 5: 
          localeru.NoX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239530);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeru.Npn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239530);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeru.Npl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(239530);
        return 0;
      }
      AppMethodBeat.o(239530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eru
 * JD-Core Version:    0.7.0.1
 */