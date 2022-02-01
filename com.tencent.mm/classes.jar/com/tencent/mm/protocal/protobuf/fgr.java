package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgr
  extends com.tencent.mm.cd.a
{
  public eae UGM;
  public eae UGN;
  public eae UGO;
  public eae UGP;
  public eae UGQ;
  public eae UGR;
  public eae UGS;
  public eae UGT;
  public eae UGU;
  public eae UGV;
  public eae UGW;
  public eae UGX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UGM != null)
      {
        paramVarArgs.oE(1, this.UGM.computeSize());
        this.UGM.writeFields(paramVarArgs);
      }
      if (this.UGN != null)
      {
        paramVarArgs.oE(2, this.UGN.computeSize());
        this.UGN.writeFields(paramVarArgs);
      }
      if (this.UGO != null)
      {
        paramVarArgs.oE(3, this.UGO.computeSize());
        this.UGO.writeFields(paramVarArgs);
      }
      if (this.UGP != null)
      {
        paramVarArgs.oE(4, this.UGP.computeSize());
        this.UGP.writeFields(paramVarArgs);
      }
      if (this.UGQ != null)
      {
        paramVarArgs.oE(5, this.UGQ.computeSize());
        this.UGQ.writeFields(paramVarArgs);
      }
      if (this.UGR != null)
      {
        paramVarArgs.oE(6, this.UGR.computeSize());
        this.UGR.writeFields(paramVarArgs);
      }
      if (this.UGS != null)
      {
        paramVarArgs.oE(7, this.UGS.computeSize());
        this.UGS.writeFields(paramVarArgs);
      }
      if (this.UGT != null)
      {
        paramVarArgs.oE(8, this.UGT.computeSize());
        this.UGT.writeFields(paramVarArgs);
      }
      if (this.UGU != null)
      {
        paramVarArgs.oE(9, this.UGU.computeSize());
        this.UGU.writeFields(paramVarArgs);
      }
      if (this.UGV != null)
      {
        paramVarArgs.oE(10, this.UGV.computeSize());
        this.UGV.writeFields(paramVarArgs);
      }
      if (this.UGW != null)
      {
        paramVarArgs.oE(11, this.UGW.computeSize());
        this.UGW.writeFields(paramVarArgs);
      }
      if (this.UGX != null)
      {
        paramVarArgs.oE(12, this.UGX.computeSize());
        this.UGX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UGM == null) {
        break label1754;
      }
    }
    label1754:
    for (int i = g.a.a.a.oD(1, this.UGM.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UGN != null) {
        paramInt = i + g.a.a.a.oD(2, this.UGN.computeSize());
      }
      i = paramInt;
      if (this.UGO != null) {
        i = paramInt + g.a.a.a.oD(3, this.UGO.computeSize());
      }
      paramInt = i;
      if (this.UGP != null) {
        paramInt = i + g.a.a.a.oD(4, this.UGP.computeSize());
      }
      i = paramInt;
      if (this.UGQ != null) {
        i = paramInt + g.a.a.a.oD(5, this.UGQ.computeSize());
      }
      paramInt = i;
      if (this.UGR != null) {
        paramInt = i + g.a.a.a.oD(6, this.UGR.computeSize());
      }
      i = paramInt;
      if (this.UGS != null) {
        i = paramInt + g.a.a.a.oD(7, this.UGS.computeSize());
      }
      paramInt = i;
      if (this.UGT != null) {
        paramInt = i + g.a.a.a.oD(8, this.UGT.computeSize());
      }
      i = paramInt;
      if (this.UGU != null) {
        i = paramInt + g.a.a.a.oD(9, this.UGU.computeSize());
      }
      paramInt = i;
      if (this.UGV != null) {
        paramInt = i + g.a.a.a.oD(10, this.UGV.computeSize());
      }
      i = paramInt;
      if (this.UGW != null) {
        i = paramInt + g.a.a.a.oD(11, this.UGW.computeSize());
      }
      paramInt = i;
      if (this.UGX != null) {
        paramInt = i + g.a.a.a.oD(12, this.UGX.computeSize());
      }
      AppMethodBeat.o(155542);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fgr localfgr = (fgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eae localeae;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155542);
          return -1;
        case 1: 
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
            localfgr.UGM = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 2: 
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
            localfgr.UGN = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 3: 
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
            localfgr.UGO = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 4: 
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
            localfgr.UGP = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
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
            localfgr.UGQ = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 6: 
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
            localfgr.UGR = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
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
            localfgr.UGS = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 8: 
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
            localfgr.UGT = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 9: 
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
            localfgr.UGU = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 10: 
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
            localfgr.UGV = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 11: 
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
            localfgr.UGW = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        }
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
          localfgr.UGX = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(155542);
        return 0;
      }
      AppMethodBeat.o(155542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgr
 * JD-Core Version:    0.7.0.1
 */