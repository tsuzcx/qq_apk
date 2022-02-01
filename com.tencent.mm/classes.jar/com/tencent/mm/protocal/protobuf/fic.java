package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fic
  extends com.tencent.mm.cd.a
{
  public int UHR;
  public fid UHS;
  public String UHT;
  public String UHU;
  public String UHV;
  public String UHW;
  public String UHX;
  public String Uba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259246);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UHR);
      if (this.UHS != null)
      {
        paramVarArgs.oE(2, this.UHS.computeSize());
        this.UHS.writeFields(paramVarArgs);
      }
      if (this.Uba != null) {
        paramVarArgs.f(3, this.Uba);
      }
      if (this.UHT != null) {
        paramVarArgs.f(4, this.UHT);
      }
      if (this.UHU != null) {
        paramVarArgs.f(5, this.UHU);
      }
      if (this.UHV != null) {
        paramVarArgs.f(6, this.UHV);
      }
      if (this.UHW != null) {
        paramVarArgs.f(7, this.UHW);
      }
      if (this.UHX != null) {
        paramVarArgs.f(8, this.UHX);
      }
      AppMethodBeat.o(259246);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UHR) + 0;
      paramInt = i;
      if (this.UHS != null) {
        paramInt = i + g.a.a.a.oD(2, this.UHS.computeSize());
      }
      i = paramInt;
      if (this.Uba != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uba);
      }
      paramInt = i;
      if (this.UHT != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UHT);
      }
      i = paramInt;
      if (this.UHU != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UHU);
      }
      paramInt = i;
      if (this.UHV != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UHV);
      }
      i = paramInt;
      if (this.UHW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UHW);
      }
      paramInt = i;
      if (this.UHX != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UHX);
      }
      AppMethodBeat.o(259246);
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
      AppMethodBeat.o(259246);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fic localfic = (fic)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259246);
        return -1;
      case 1: 
        localfic.UHR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(259246);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fid localfid = new fid();
          if ((localObject != null) && (localObject.length > 0)) {
            localfid.parseFrom((byte[])localObject);
          }
          localfic.UHS = localfid;
          paramInt += 1;
        }
        AppMethodBeat.o(259246);
        return 0;
      case 3: 
        localfic.Uba = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 4: 
        localfic.UHT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 5: 
        localfic.UHU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 6: 
        localfic.UHV = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 7: 
        localfic.UHW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(259246);
        return 0;
      }
      localfic.UHX = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(259246);
      return 0;
    }
    AppMethodBeat.o(259246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fic
 * JD-Core Version:    0.7.0.1
 */