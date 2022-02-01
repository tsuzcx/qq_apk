package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cda
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int ZjF;
  public int aajd;
  public String aamA;
  public String aamB;
  public int aamC;
  public gol aamD;
  public int aamo;
  public String aamy;
  public String aamz;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZjF);
      if (this.aamy != null) {
        paramVarArgs.g(2, this.aamy);
      }
      if (this.oOI != null) {
        paramVarArgs.g(3, this.oOI);
      }
      if (this.aamz != null) {
        paramVarArgs.g(4, this.aamz);
      }
      if (this.aamA != null) {
        paramVarArgs.g(5, this.aamA);
      }
      if (this.aamB != null) {
        paramVarArgs.g(7, this.aamB);
      }
      paramVarArgs.bS(8, this.aamo);
      paramVarArgs.bS(9, this.IJG);
      paramVarArgs.bS(11, this.aamC);
      paramVarArgs.bS(12, this.aajd);
      if (this.aamD != null)
      {
        paramVarArgs.qD(13, this.aamD.computeSize());
        this.aamD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZjF) + 0;
      paramInt = i;
      if (this.aamy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aamy);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oOI);
      }
      paramInt = i;
      if (this.aamz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aamz);
      }
      i = paramInt;
      if (this.aamA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aamA);
      }
      paramInt = i;
      if (this.aamB != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aamB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aamo) + i.a.a.b.b.a.cJ(9, this.IJG) + i.a.a.b.b.a.cJ(11, this.aamC) + i.a.a.b.b.a.cJ(12, this.aajd);
      paramInt = i;
      if (this.aamD != null) {
        paramInt = i + i.a.a.a.qC(13, this.aamD.computeSize());
      }
      AppMethodBeat.o(152546);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cda localcda = (cda)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 6: 
      case 10: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localcda.ZjF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localcda.aamy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localcda.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localcda.aamz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localcda.aamA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localcda.aamB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localcda.aamo = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152546);
        return 0;
      case 9: 
        localcda.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152546);
        return 0;
      case 11: 
        localcda.aamC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152546);
        return 0;
      case 12: 
        localcda.aajd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152546);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gol localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localcda.aamD = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cda
 * JD-Core Version:    0.7.0.1
 */