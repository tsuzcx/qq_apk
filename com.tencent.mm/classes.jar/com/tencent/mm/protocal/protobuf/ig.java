package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ig
  extends com.tencent.mm.cd.a
  implements eip
{
  public int CqV;
  public String ID;
  public eae RMR;
  public String RNB;
  public eae RNC;
  public String RND;
  public int RNE;
  public String RNF;
  public String RNG;
  
  public final int getRet()
  {
    return this.CqV;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32136);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CqV);
      if (this.RNC != null)
      {
        paramVarArgs.oE(2, this.RNC.computeSize());
        this.RNC.writeFields(paramVarArgs);
      }
      if (this.RND != null) {
        paramVarArgs.f(3, this.RND);
      }
      if (this.RMR != null)
      {
        paramVarArgs.oE(4, this.RMR.computeSize());
        this.RMR.writeFields(paramVarArgs);
      }
      if (this.RNF != null) {
        paramVarArgs.f(5, this.RNF);
      }
      if (this.RNG != null) {
        paramVarArgs.f(6, this.RNG);
      }
      paramVarArgs.aY(7, this.RNE);
      if (this.ID != null) {
        paramVarArgs.f(8, this.ID);
      }
      if (this.RNB != null) {
        paramVarArgs.f(9, this.RNB);
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.RNC != null) {
        paramInt = i + g.a.a.a.oD(2, this.RNC.computeSize());
      }
      i = paramInt;
      if (this.RND != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RND);
      }
      paramInt = i;
      if (this.RMR != null) {
        paramInt = i + g.a.a.a.oD(4, this.RMR.computeSize());
      }
      i = paramInt;
      if (this.RNF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RNF);
      }
      paramInt = i;
      if (this.RNG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RNG);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.RNE);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ID);
      }
      i = paramInt;
      if (this.RNB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RNB);
      }
      AppMethodBeat.o(32136);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RNC == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.RMR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ig localig = (ig)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eae localeae;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32136);
        return -1;
      case 1: 
        localig.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32136);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localig.RNC = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 3: 
        localig.RND = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localig.RMR = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 5: 
        localig.RNF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 6: 
        localig.RNG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 7: 
        localig.RNE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32136);
        return 0;
      case 8: 
        localig.ID = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32136);
        return 0;
      }
      localig.RNB = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(32136);
      return 0;
    }
    AppMethodBeat.o(32136);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ig
 * JD-Core Version:    0.7.0.1
 */