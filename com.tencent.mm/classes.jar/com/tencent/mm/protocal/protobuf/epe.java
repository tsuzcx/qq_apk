package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class epe
  extends dyl
{
  public LinkedList<epd> COK;
  public int CPw;
  public String RTS;
  public int RUc;
  public int RXp;
  public String SessionId;
  public b Tkb;
  public int UrH;
  public String UrI;
  public dmw UrJ;
  public int UrK;
  public String UrL;
  public int Urz;
  public String lVG;
  
  public epe()
  {
    AppMethodBeat.i(152704);
    this.COK = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RTS != null) {
        paramVarArgs.f(2, this.RTS);
      }
      paramVarArgs.aY(3, this.RXp);
      paramVarArgs.e(4, 8, this.COK);
      paramVarArgs.aY(5, this.UrH);
      if (this.lVG != null) {
        paramVarArgs.f(6, this.lVG);
      }
      paramVarArgs.aY(7, this.RUc);
      paramVarArgs.aY(8, this.Urz);
      if (this.UrI != null) {
        paramVarArgs.f(9, this.UrI);
      }
      if (this.Tkb != null) {
        paramVarArgs.c(10, this.Tkb);
      }
      if (this.UrJ != null)
      {
        paramVarArgs.oE(11, this.UrJ.computeSize());
        this.UrJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.CPw);
      paramVarArgs.aY(13, this.UrK);
      if (this.SessionId != null) {
        paramVarArgs.f(14, this.SessionId);
      }
      if (this.UrL != null) {
        paramVarArgs.f(15, this.UrL);
      }
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1176;
      }
    }
    label1176:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RTS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RTS);
      }
      i = i + g.a.a.b.b.a.bM(3, this.RXp) + g.a.a.a.c(4, 8, this.COK) + g.a.a.b.b.a.bM(5, this.UrH);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.RUc) + g.a.a.b.b.a.bM(8, this.Urz);
      paramInt = i;
      if (this.UrI != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UrI);
      }
      i = paramInt;
      if (this.Tkb != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.Tkb);
      }
      paramInt = i;
      if (this.UrJ != null) {
        paramInt = i + g.a.a.a.oD(11, this.UrJ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.CPw) + g.a.a.b.b.a.bM(13, this.UrK);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SessionId);
      }
      i = paramInt;
      if (this.UrL != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.UrL);
      }
      AppMethodBeat.o(152705);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.COK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epe localepe = (epe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localepe.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localepe.RTS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localepe.RXp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epd)localObject2).parseFrom((byte[])localObject1);
            }
            localepe.COK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localepe.UrH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localepe.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localepe.RUc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localepe.Urz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localepe.UrI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localepe.Tkb = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmw)localObject2).parseFrom((byte[])localObject1);
            }
            localepe.UrJ = ((dmw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 12: 
          localepe.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 13: 
          localepe.UrK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152705);
          return 0;
        case 14: 
          localepe.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152705);
          return 0;
        }
        localepe.UrL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epe
 * JD-Core Version:    0.7.0.1
 */