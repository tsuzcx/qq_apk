package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vy
  extends com.tencent.mm.bx.a
{
  public String YBH;
  public String Zca;
  public int Zcl;
  public String Zcm;
  public wg Zcn;
  public String Zco;
  public String background_url;
  public String iaI;
  public String icon_url;
  public String mee;
  public int tNW;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259014);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI != null) {
        paramVarArgs.g(1, this.iaI);
      }
      if (this.YBH != null) {
        paramVarArgs.g(2, this.YBH);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.mee != null) {
        paramVarArgs.g(4, this.mee);
      }
      if (this.background_url != null) {
        paramVarArgs.g(5, this.background_url);
      }
      if (this.Zca != null) {
        paramVarArgs.g(6, this.Zca);
      }
      paramVarArgs.bS(7, this.tNW);
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      paramVarArgs.bS(9, this.Zcl);
      if (this.Zcm != null) {
        paramVarArgs.g(10, this.Zcm);
      }
      if (this.Zcn != null)
      {
        paramVarArgs.qD(11, this.Zcn.computeSize());
        this.Zcn.writeFields(paramVarArgs);
      }
      if (this.Zco != null) {
        paramVarArgs.g(12, this.Zco);
      }
      AppMethodBeat.o(259014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iaI == null) {
        break label928;
      }
    }
    label928:
    for (int i = i.a.a.b.b.a.h(1, this.iaI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YBH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBH);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.mee != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.mee);
      }
      i = paramInt;
      if (this.background_url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.background_url);
      }
      paramInt = i;
      if (this.Zca != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zca);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.tNW);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.Zcl);
      paramInt = i;
      if (this.Zcm != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zcm);
      }
      i = paramInt;
      if (this.Zcn != null) {
        i = paramInt + i.a.a.a.qC(11, this.Zcn.computeSize());
      }
      paramInt = i;
      if (this.Zco != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Zco);
      }
      AppMethodBeat.o(259014);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259014);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        vy localvy = (vy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259014);
          return -1;
        case 1: 
          localvy.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 2: 
          localvy.YBH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 3: 
          localvy.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 4: 
          localvy.mee = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 5: 
          localvy.background_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 6: 
          localvy.Zca = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 7: 
          localvy.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259014);
          return 0;
        case 8: 
          localvy.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 9: 
          localvy.Zcl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259014);
          return 0;
        case 10: 
          localvy.Zcm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259014);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            wg localwg = new wg();
            if ((localObject != null) && (localObject.length > 0)) {
              localwg.parseFrom((byte[])localObject);
            }
            localvy.Zcn = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(259014);
          return 0;
        }
        localvy.Zco = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259014);
        return 0;
      }
      AppMethodBeat.o(259014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vy
 * JD-Core Version:    0.7.0.1
 */