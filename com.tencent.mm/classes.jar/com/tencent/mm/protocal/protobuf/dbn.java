package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbn
  extends com.tencent.mm.cd.a
{
  public String SOM;
  public String TIO;
  public String TIQ;
  public String TIR;
  public String TIS;
  public String TIT;
  public String TIU;
  public String appId;
  public String fMd;
  public dbr lVY;
  public int musicType;
  public String name;
  public String ozs;
  public String ozt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVY != null)
      {
        paramVarArgs.oE(1, this.lVY.computeSize());
        this.lVY.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.musicType);
      if (this.SOM != null) {
        paramVarArgs.f(3, this.SOM);
      }
      if (this.name != null) {
        paramVarArgs.f(4, this.name);
      }
      if (this.ozs != null) {
        paramVarArgs.f(5, this.ozs);
      }
      if (this.ozt != null) {
        paramVarArgs.f(6, this.ozt);
      }
      if (this.TIO != null) {
        paramVarArgs.f(7, this.TIO);
      }
      if (this.TIQ != null) {
        paramVarArgs.f(8, this.TIQ);
      }
      if (this.fMd != null) {
        paramVarArgs.f(9, this.fMd);
      }
      if (this.TIR != null) {
        paramVarArgs.f(10, this.TIR);
      }
      if (this.TIS != null) {
        paramVarArgs.f(11, this.TIS);
      }
      if (this.TIT != null) {
        paramVarArgs.f(12, this.TIT);
      }
      if (this.appId != null) {
        paramVarArgs.f(13, this.appId);
      }
      if (this.TIU != null) {
        paramVarArgs.f(14, this.TIU);
      }
      AppMethodBeat.o(205554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVY == null) {
        break label1072;
      }
    }
    label1072:
    for (paramInt = g.a.a.a.oD(1, this.lVY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.musicType);
      paramInt = i;
      if (this.SOM != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SOM);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.name);
      }
      paramInt = i;
      if (this.ozs != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ozs);
      }
      i = paramInt;
      if (this.ozt != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ozt);
      }
      paramInt = i;
      if (this.TIO != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TIO);
      }
      i = paramInt;
      if (this.TIQ != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TIQ);
      }
      paramInt = i;
      if (this.fMd != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.fMd);
      }
      i = paramInt;
      if (this.TIR != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TIR);
      }
      paramInt = i;
      if (this.TIS != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TIS);
      }
      i = paramInt;
      if (this.TIT != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TIT);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.appId);
      }
      i = paramInt;
      if (this.TIU != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TIU);
      }
      AppMethodBeat.o(205554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dbn localdbn = (dbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205554);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dbr localdbr = new dbr();
            if ((localObject != null) && (localObject.length > 0)) {
              localdbr.parseFrom((byte[])localObject);
            }
            localdbn.lVY = localdbr;
            paramInt += 1;
          }
          AppMethodBeat.o(205554);
          return 0;
        case 2: 
          localdbn.musicType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205554);
          return 0;
        case 3: 
          localdbn.SOM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 4: 
          localdbn.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 5: 
          localdbn.ozs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 6: 
          localdbn.ozt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 7: 
          localdbn.TIO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 8: 
          localdbn.TIQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 9: 
          localdbn.fMd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 10: 
          localdbn.TIR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 11: 
          localdbn.TIS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 12: 
          localdbn.TIT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        case 13: 
          localdbn.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205554);
          return 0;
        }
        localdbn.TIU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205554);
        return 0;
      }
      AppMethodBeat.o(205554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbn
 * JD-Core Version:    0.7.0.1
 */