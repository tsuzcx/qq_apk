package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvr
  extends com.tencent.mm.bx.a
{
  public int Vlg;
  public String Vli;
  public String Vlj;
  public String Vlk;
  public String Vll;
  public String Vlm;
  public String Vln;
  public int VmW;
  public dvs abbk;
  public String abbl;
  public String abbm;
  public int abbn;
  public String abbo;
  public String abbp;
  public String abbq;
  public String abbr;
  public String abbs;
  public String abbt;
  public String background_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.VmW);
      if (this.abbk != null)
      {
        paramVarArgs.qD(2, this.abbk.computeSize());
        this.abbk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Vlg);
      if (this.Vli != null) {
        paramVarArgs.g(4, this.Vli);
      }
      if (this.Vlj != null) {
        paramVarArgs.g(5, this.Vlj);
      }
      if (this.Vlk != null) {
        paramVarArgs.g(6, this.Vlk);
      }
      if (this.Vll != null) {
        paramVarArgs.g(7, this.Vll);
      }
      if (this.Vlm != null) {
        paramVarArgs.g(8, this.Vlm);
      }
      if (this.Vln != null) {
        paramVarArgs.g(9, this.Vln);
      }
      if (this.background_color != null) {
        paramVarArgs.g(10, this.background_color);
      }
      if (this.abbl != null) {
        paramVarArgs.g(11, this.abbl);
      }
      if (this.abbm != null) {
        paramVarArgs.g(12, this.abbm);
      }
      paramVarArgs.bS(13, this.abbn);
      if (this.abbo != null) {
        paramVarArgs.g(14, this.abbo);
      }
      if (this.abbp != null) {
        paramVarArgs.g(15, this.abbp);
      }
      if (this.abbq != null) {
        paramVarArgs.g(16, this.abbq);
      }
      if (this.abbr != null) {
        paramVarArgs.g(17, this.abbr);
      }
      if (this.abbs != null) {
        paramVarArgs.g(18, this.abbs);
      }
      if (this.abbt != null) {
        paramVarArgs.g(19, this.abbt);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.VmW) + 0;
      paramInt = i;
      if (this.abbk != null) {
        paramInt = i + i.a.a.a.qC(2, this.abbk.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Vlg);
      paramInt = i;
      if (this.Vli != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Vli);
      }
      i = paramInt;
      if (this.Vlj != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Vlj);
      }
      paramInt = i;
      if (this.Vlk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Vlk);
      }
      i = paramInt;
      if (this.Vll != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Vll);
      }
      paramInt = i;
      if (this.Vlm != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Vlm);
      }
      i = paramInt;
      if (this.Vln != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Vln);
      }
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.background_color);
      }
      i = paramInt;
      if (this.abbl != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abbl);
      }
      paramInt = i;
      if (this.abbm != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abbm);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.abbn);
      paramInt = i;
      if (this.abbo != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abbo);
      }
      i = paramInt;
      if (this.abbp != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abbp);
      }
      paramInt = i;
      if (this.abbq != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abbq);
      }
      i = paramInt;
      if (this.abbr != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abbr);
      }
      paramInt = i;
      if (this.abbs != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abbs);
      }
      i = paramInt;
      if (this.abbt != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.abbt);
      }
      AppMethodBeat.o(72526);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dvr localdvr = (dvr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localdvr.VmW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvs localdvs = new dvs();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvs.parseFrom((byte[])localObject);
          }
          localdvr.abbk = localdvs;
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localdvr.Vlg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localdvr.Vli = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localdvr.Vlj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localdvr.Vlk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localdvr.Vll = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localdvr.Vlm = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localdvr.Vln = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 10: 
        localdvr.background_color = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 11: 
        localdvr.abbl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 12: 
        localdvr.abbm = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 13: 
        localdvr.abbn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72526);
        return 0;
      case 14: 
        localdvr.abbo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 15: 
        localdvr.abbp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 16: 
        localdvr.abbq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 17: 
        localdvr.abbr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 18: 
        localdvr.abbs = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localdvr.abbt = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvr
 * JD-Core Version:    0.7.0.1
 */