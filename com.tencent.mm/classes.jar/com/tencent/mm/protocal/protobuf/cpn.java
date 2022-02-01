package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cpn
  extends com.tencent.mm.cd.a
{
  public String SvX;
  public String Swi;
  public LinkedList<String> Swj;
  public boolean Swk;
  public int TwS;
  public cpi TwT;
  
  public cpn()
  {
    AppMethodBeat.i(252288);
    this.Swj = new LinkedList();
    AppMethodBeat.o(252288);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(252290);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SvX == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(252290);
        throw paramVarArgs;
      }
      if (this.SvX != null) {
        paramVarArgs.f(1, this.SvX);
      }
      if (this.Swi != null) {
        paramVarArgs.f(2, this.Swi);
      }
      paramVarArgs.e(3, 1, this.Swj);
      paramVarArgs.co(4, this.Swk);
      paramVarArgs.aY(5, this.TwS);
      if (this.TwT != null)
      {
        paramVarArgs.oE(6, this.TwT.computeSize());
        this.TwT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(252290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SvX == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.b.b.a.g(1, this.SvX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Swi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Swi);
      }
      i = i + g.a.a.a.c(3, 1, this.Swj) + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.b.b.a.bM(5, this.TwS);
      paramInt = i;
      if (this.TwT != null) {
        paramInt = i + g.a.a.a.oD(6, this.TwT.computeSize());
      }
      AppMethodBeat.o(252290);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Swj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SvX == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(252290);
          throw paramVarArgs;
        }
        AppMethodBeat.o(252290);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cpn localcpn = (cpn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(252290);
          return -1;
        case 1: 
          localcpn.SvX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252290);
          return 0;
        case 2: 
          localcpn.Swi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(252290);
          return 0;
        case 3: 
          localcpn.Swj.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(252290);
          return 0;
        case 4: 
          localcpn.Swk = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(252290);
          return 0;
        case 5: 
          localcpn.TwS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(252290);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cpi localcpi = new cpi();
          if ((localObject != null) && (localObject.length > 0)) {
            localcpi.parseFrom((byte[])localObject);
          }
          localcpn.TwT = localcpi;
          paramInt += 1;
        }
        AppMethodBeat.o(252290);
        return 0;
      }
      AppMethodBeat.o(252290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpn
 * JD-Core Version:    0.7.0.1
 */