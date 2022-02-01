package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmd
  extends com.tencent.mm.cd.a
{
  public float GtJ;
  public String TTA;
  public String TTB;
  public String TTC;
  public float TTD;
  public int TTE;
  public String TTF;
  public LinkedList<String> TTG;
  public String TTH;
  public String TTt;
  public String TTv;
  public String TTw;
  public String TTx;
  public String TTy;
  public String TTz;
  
  public dmd()
  {
    AppMethodBeat.i(203779);
    this.TTG = new LinkedList();
    AppMethodBeat.o(203779);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TTv != null) {
        paramVarArgs.f(1, this.TTv);
      }
      paramVarArgs.i(2, this.GtJ);
      if (this.TTw != null) {
        paramVarArgs.f(3, this.TTw);
      }
      if (this.TTx != null) {
        paramVarArgs.f(4, this.TTx);
      }
      if (this.TTt != null) {
        paramVarArgs.f(5, this.TTt);
      }
      if (this.TTy != null) {
        paramVarArgs.f(6, this.TTy);
      }
      if (this.TTz != null) {
        paramVarArgs.f(7, this.TTz);
      }
      if (this.TTA != null) {
        paramVarArgs.f(8, this.TTA);
      }
      if (this.TTB != null) {
        paramVarArgs.f(9, this.TTB);
      }
      if (this.TTC != null) {
        paramVarArgs.f(10, this.TTC);
      }
      paramVarArgs.i(11, this.TTD);
      paramVarArgs.aY(12, this.TTE);
      if (this.TTF != null) {
        paramVarArgs.f(13, this.TTF);
      }
      paramVarArgs.e(14, 1, this.TTG);
      if (this.TTH != null) {
        paramVarArgs.f(101, this.TTH);
      }
      AppMethodBeat.o(203798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TTv == null) {
        break label1080;
      }
    }
    label1080:
    for (paramInt = g.a.a.b.b.a.g(1, this.TTv) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 4);
      paramInt = i;
      if (this.TTw != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TTw);
      }
      i = paramInt;
      if (this.TTx != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TTx);
      }
      paramInt = i;
      if (this.TTt != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TTt);
      }
      i = paramInt;
      if (this.TTy != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TTy);
      }
      paramInt = i;
      if (this.TTz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TTz);
      }
      i = paramInt;
      if (this.TTA != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TTA);
      }
      paramInt = i;
      if (this.TTB != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TTB);
      }
      i = paramInt;
      if (this.TTC != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TTC);
      }
      i = i + (g.a.a.b.b.a.gL(11) + 4) + g.a.a.b.b.a.bM(12, this.TTE);
      paramInt = i;
      if (this.TTF != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.TTF);
      }
      i = paramInt + g.a.a.a.c(14, 1, this.TTG);
      paramInt = i;
      if (this.TTH != null) {
        paramInt = i + g.a.a.b.b.a.g(101, this.TTH);
      }
      AppMethodBeat.o(203798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TTG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203798);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmd localdmd = (dmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203798);
          return -1;
        case 1: 
          localdmd.TTv = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 2: 
          localdmd.GtJ = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(203798);
          return 0;
        case 3: 
          localdmd.TTw = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 4: 
          localdmd.TTx = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 5: 
          localdmd.TTt = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 6: 
          localdmd.TTy = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 7: 
          localdmd.TTz = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 8: 
          localdmd.TTA = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 9: 
          localdmd.TTB = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 10: 
          localdmd.TTC = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 11: 
          localdmd.TTD = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(203798);
          return 0;
        case 12: 
          localdmd.TTE = locala.abFh.AK();
          AppMethodBeat.o(203798);
          return 0;
        case 13: 
          localdmd.TTF = locala.abFh.readString();
          AppMethodBeat.o(203798);
          return 0;
        case 14: 
          localdmd.TTG.add(locala.abFh.readString());
          AppMethodBeat.o(203798);
          return 0;
        }
        localdmd.TTH = locala.abFh.readString();
        AppMethodBeat.o(203798);
        return 0;
      }
      AppMethodBeat.o(203798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmd
 * JD-Core Version:    0.7.0.1
 */