package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayv
  extends com.tencent.mm.cd.a
{
  public String SKM;
  public int SKN;
  public String SKO;
  public bbq SKP;
  public LinkedList<bbq> SKQ;
  public int SpF;
  public String Spt;
  public String Spy;
  public String SvW;
  
  public ayv()
  {
    AppMethodBeat.i(200617);
    this.SKQ = new LinkedList();
    AppMethodBeat.o(200617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200626);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SpF);
      if (this.SKM != null) {
        paramVarArgs.f(2, this.SKM);
      }
      paramVarArgs.aY(3, this.SKN);
      if (this.Spt != null) {
        paramVarArgs.f(4, this.Spt);
      }
      if (this.SvW != null) {
        paramVarArgs.f(5, this.SvW);
      }
      if (this.SKO != null) {
        paramVarArgs.f(6, this.SKO);
      }
      if (this.Spy != null) {
        paramVarArgs.f(7, this.Spy);
      }
      if (this.SKP != null)
      {
        paramVarArgs.oE(8, this.SKP.computeSize());
        this.SKP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.SKQ);
      AppMethodBeat.o(200626);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SpF) + 0;
      paramInt = i;
      if (this.SKM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SKM);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SKN);
      paramInt = i;
      if (this.Spt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Spt);
      }
      i = paramInt;
      if (this.SvW != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SvW);
      }
      paramInt = i;
      if (this.SKO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SKO);
      }
      i = paramInt;
      if (this.Spy != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Spy);
      }
      paramInt = i;
      if (this.SKP != null) {
        paramInt = i + g.a.a.a.oD(8, this.SKP.computeSize());
      }
      i = g.a.a.a.c(9, 8, this.SKQ);
      AppMethodBeat.o(200626);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SKQ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200626);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ayv localayv = (ayv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      bbq localbbq;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200626);
        return -1;
      case 1: 
        localayv.SpF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(200626);
        return 0;
      case 2: 
        localayv.SKM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200626);
        return 0;
      case 3: 
        localayv.SKN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(200626);
        return 0;
      case 4: 
        localayv.Spt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200626);
        return 0;
      case 5: 
        localayv.SvW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200626);
        return 0;
      case 6: 
        localayv.SKO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200626);
        return 0;
      case 7: 
        localayv.Spy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200626);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbbq = new bbq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbbq.parseFrom((byte[])localObject);
          }
          localayv.SKP = localbbq;
          paramInt += 1;
        }
        AppMethodBeat.o(200626);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localbbq = new bbq();
        if ((localObject != null) && (localObject.length > 0)) {
          localbbq.parseFrom((byte[])localObject);
        }
        localayv.SKQ.add(localbbq);
        paramInt += 1;
      }
      AppMethodBeat.o(200626);
      return 0;
    }
    AppMethodBeat.o(200626);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayv
 * JD-Core Version:    0.7.0.1
 */