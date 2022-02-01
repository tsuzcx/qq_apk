package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evx
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YFu;
  public String ZhO;
  public String ZhP;
  public String ZoW;
  public String ZoX;
  public String aant;
  public int abxU;
  public dxj abyy;
  public String abyz;
  public String oOI;
  public int pSf;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.ZoW != null) {
        paramVarArgs.g(3, this.ZoW);
      }
      if (this.ZoX != null) {
        paramVarArgs.g(4, this.ZoX);
      }
      paramVarArgs.bS(5, this.pSf);
      if (this.ZhO != null) {
        paramVarArgs.g(6, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(7, this.ZhP);
      }
      if (this.oOI != null) {
        paramVarArgs.g(8, this.oOI);
      }
      paramVarArgs.bS(9, this.abxU);
      if (this.abyy != null)
      {
        paramVarArgs.qD(10, this.abyy.computeSize());
        this.abyy.writeFields(paramVarArgs);
      }
      if (this.aant != null) {
        paramVarArgs.g(11, this.aant);
      }
      if (this.abyz != null) {
        paramVarArgs.g(12, this.abyz);
      }
      paramVarArgs.bS(13, this.YFu);
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label972;
      }
    }
    label972:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.ZoW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZoW);
      }
      paramInt = i;
      if (this.ZoX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZoX);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.pSf);
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZhP);
      }
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.oOI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.abxU);
      paramInt = i;
      if (this.abyy != null) {
        paramInt = i + i.a.a.a.qC(10, this.abyy.computeSize());
      }
      i = paramInt;
      if (this.aant != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aant);
      }
      paramInt = i;
      if (this.abyz != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abyz);
      }
      i = i.a.a.b.b.a.cJ(13, this.YFu);
      AppMethodBeat.o(152685);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        evx localevx = (evx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localevx.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localevx.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localevx.ZoW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localevx.ZoX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localevx.pSf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localevx.ZhO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localevx.ZhP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localevx.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localevx.abxU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dxj localdxj = new dxj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdxj.parseFrom((byte[])localObject);
            }
            localevx.abyy = localdxj;
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        case 11: 
          localevx.aant = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 12: 
          localevx.abyz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152685);
          return 0;
        }
        localevx.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evx
 * JD-Core Version:    0.7.0.1
 */