package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkb
  extends dyl
{
  public LinkedList<FinderContact> SGP;
  public String SGm;
  public LinkedList<FinderContact> SSd;
  public eae SUZ;
  public LinkedList<bhw> SVa;
  public String SVb;
  public LinkedList<bhw> SVc;
  public String SVd;
  public int SVe;
  public int fFT;
  public String finderUsername;
  public int scene;
  public aqe yjp;
  
  public bkb()
  {
    AppMethodBeat.i(169060);
    this.SGP = new LinkedList();
    this.SSd = new LinkedList();
    this.SVa = new LinkedList();
    this.SVc = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fFT);
      if (this.SUZ != null)
      {
        paramVarArgs.oE(3, this.SUZ.computeSize());
        this.SUZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.SGP);
      paramVarArgs.e(5, 8, this.SSd);
      if (this.finderUsername != null) {
        paramVarArgs.f(6, this.finderUsername);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.scene);
      paramVarArgs.e(9, 8, this.SVa);
      if (this.SVb != null) {
        paramVarArgs.f(10, this.SVb);
      }
      paramVarArgs.e(11, 8, this.SVc);
      if (this.SVd != null) {
        paramVarArgs.f(12, this.SVd);
      }
      paramVarArgs.aY(13, this.SVe);
      if (this.SGm != null) {
        paramVarArgs.f(14, this.SGm);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1408;
      }
    }
    label1408:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fFT);
      paramInt = i;
      if (this.SUZ != null) {
        paramInt = i + g.a.a.a.oD(3, this.SUZ.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.SGP) + g.a.a.a.c(5, 8, this.SSd);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.finderUsername);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(8, this.scene) + g.a.a.a.c(9, 8, this.SVa);
      paramInt = i;
      if (this.SVb != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SVb);
      }
      i = paramInt + g.a.a.a.c(11, 8, this.SVc);
      paramInt = i;
      if (this.SVd != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SVd);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.SVe);
      paramInt = i;
      if (this.SGm != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SGm);
      }
      AppMethodBeat.o(169061);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGP.clear();
        this.SSd.clear();
        this.SVa.clear();
        this.SVc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkb localbkb = (bkb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
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
            localbkb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localbkb.fFT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbkb.SUZ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbkb.SGP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbkb.SSd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localbkb.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbkb.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 8: 
          localbkb.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169061);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhw)localObject2).parseFrom((byte[])localObject1);
            }
            localbkb.SVa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 10: 
          localbkb.SVb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhw)localObject2).parseFrom((byte[])localObject1);
            }
            localbkb.SVc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 12: 
          localbkb.SVd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 13: 
          localbkb.SVe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169061);
          return 0;
        }
        localbkb.SGm = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkb
 * JD-Core Version:    0.7.0.1
 */