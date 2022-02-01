package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhn
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int CRP;
  public String Md5;
  public eae RJR;
  public String Suv;
  public eae TOI;
  public int rWo;
  public int rWt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CRP);
      paramVarArgs.aY(2, this.rWt);
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      paramVarArgs.aY(4, this.rWo);
      if (this.RJR != null)
      {
        paramVarArgs.oE(5, this.RJR.computeSize());
        this.RJR.writeFields(paramVarArgs);
      }
      if (this.Suv != null) {
        paramVarArgs.f(6, this.Suv);
      }
      if (this.TOI != null)
      {
        paramVarArgs.oE(7, this.TOI.computeSize());
        this.TOI.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CRP) + 0 + g.a.a.b.b.a.bM(2, this.rWt);
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CMP);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.rWo);
      paramInt = i;
      if (this.RJR != null) {
        paramInt = i + g.a.a.a.oD(5, this.RJR.computeSize());
      }
      i = paramInt;
      if (this.Suv != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Suv);
      }
      paramInt = i;
      if (this.TOI != null) {
        paramInt = i + g.a.a.a.oD(7, this.TOI.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Md5);
      }
      AppMethodBeat.o(152659);
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
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dhn localdhn = (dhn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      eae localeae;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localdhn.CRP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localdhn.rWt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localdhn.CMP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localdhn.rWo = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
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
          localdhn.RJR = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localdhn.Suv = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
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
          localdhn.TOI = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localdhn.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhn
 * JD-Core Version:    0.7.0.1
 */