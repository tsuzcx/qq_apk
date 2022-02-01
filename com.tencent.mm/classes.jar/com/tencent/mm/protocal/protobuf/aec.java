package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aec
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public String ROQ;
  public LinkedList<erh> Sfr;
  public LinkedList<erh> SqJ;
  public String SqK;
  public int state;
  
  public aec()
  {
    AppMethodBeat.i(91427);
    this.Sfr = new LinkedList();
    this.SqJ = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.state);
      if (this.RGf != null)
      {
        paramVarArgs.oE(2, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Sfr);
      paramVarArgs.e(4, 8, this.SqJ);
      if (this.SqK != null) {
        paramVarArgs.f(5, this.SqK);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(6, this.ROQ);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.state) + 0;
      paramInt = i;
      if (this.RGf != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGf.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.Sfr) + g.a.a.a.c(4, 8, this.SqJ);
      paramInt = i;
      if (this.SqK != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SqK);
      }
      i = paramInt;
      if (this.ROQ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ROQ);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sfr.clear();
      this.SqJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aec localaec = (aec)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      erh localerh;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localaec.state = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localerh = new erh();
          if ((localObject != null) && (localObject.length > 0)) {
            localerh.parseFrom((byte[])localObject);
          }
          localaec.RGf = localerh;
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localerh = new erh();
          if ((localObject != null) && (localObject.length > 0)) {
            localerh.parseFrom((byte[])localObject);
          }
          localaec.Sfr.add(localerh);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localerh = new erh();
          if ((localObject != null) && (localObject.length > 0)) {
            localerh.parseFrom((byte[])localObject);
          }
          localaec.SqJ.add(localerh);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localaec.SqK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localaec.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aec
 * JD-Core Version:    0.7.0.1
 */