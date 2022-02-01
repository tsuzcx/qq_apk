package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcq
  extends com.tencent.mm.cd.a
{
  public String desc;
  public String jDL;
  public int promoting;
  public String title;
  public long zaI;
  public ch zaJ;
  public String zaK;
  public String zaL;
  public String zaM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230548);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.zaI);
      if (this.zaJ != null)
      {
        paramVarArgs.oE(2, this.zaJ.computeSize());
        this.zaJ.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.zaK != null) {
        paramVarArgs.f(4, this.zaK);
      }
      if (this.desc != null) {
        paramVarArgs.f(5, this.desc);
      }
      if (this.zaL != null) {
        paramVarArgs.f(6, this.zaL);
      }
      if (this.zaM != null) {
        paramVarArgs.f(7, this.zaM);
      }
      paramVarArgs.aY(8, this.promoting);
      if (this.jDL != null) {
        paramVarArgs.f(9, this.jDL);
      }
      AppMethodBeat.o(230548);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.zaI) + 0;
      paramInt = i;
      if (this.zaJ != null) {
        paramInt = i + g.a.a.a.oD(2, this.zaJ.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.zaK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.zaK);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.desc);
      }
      paramInt = i;
      if (this.zaL != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.zaL);
      }
      i = paramInt;
      if (this.zaM != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.zaM);
      }
      i += g.a.a.b.b.a.bM(8, this.promoting);
      paramInt = i;
      if (this.jDL != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.jDL);
      }
      AppMethodBeat.o(230548);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230548);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bcq localbcq = (bcq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(230548);
        return -1;
      case 1: 
        localbcq.zaI = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(230548);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ch localch = new ch();
          if ((localObject != null) && (localObject.length > 0)) {
            localch.parseFrom((byte[])localObject);
          }
          localbcq.zaJ = localch;
          paramInt += 1;
        }
        AppMethodBeat.o(230548);
        return 0;
      case 3: 
        localbcq.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230548);
        return 0;
      case 4: 
        localbcq.zaK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230548);
        return 0;
      case 5: 
        localbcq.desc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230548);
        return 0;
      case 6: 
        localbcq.zaL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230548);
        return 0;
      case 7: 
        localbcq.zaM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230548);
        return 0;
      case 8: 
        localbcq.promoting = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230548);
        return 0;
      }
      localbcq.jDL = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(230548);
      return 0;
    }
    AppMethodBeat.o(230548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcq
 * JD-Core Version:    0.7.0.1
 */