package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmo
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public String RTi;
  public String RTk;
  public String RTm;
  public String RTn;
  public String RTo;
  public fbh Tua;
  public fcs Tub;
  public dle Tuc;
  public String fwr;
  public int lpx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205857);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.RTi != null) {
        paramVarArgs.f(2, this.RTi);
      }
      if (this.RTk != null) {
        paramVarArgs.f(3, this.RTk);
      }
      if (this.RTm != null) {
        paramVarArgs.f(4, this.RTm);
      }
      if (this.RTn != null) {
        paramVarArgs.f(5, this.RTn);
      }
      if (this.RTo != null) {
        paramVarArgs.f(6, this.RTo);
      }
      paramVarArgs.aY(7, this.lpx);
      paramVarArgs.aY(8, this.CreateTime);
      if (this.Tua != null)
      {
        paramVarArgs.oE(9, this.Tua.computeSize());
        this.Tua.writeFields(paramVarArgs);
      }
      if (this.Tub != null)
      {
        paramVarArgs.oE(10, this.Tub.computeSize());
        this.Tub.writeFields(paramVarArgs);
      }
      if (this.Tuc != null)
      {
        paramVarArgs.oE(11, this.Tuc.computeSize());
        this.Tuc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(205857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label1012;
      }
    }
    label1012:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RTi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RTi);
      }
      i = paramInt;
      if (this.RTk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RTk);
      }
      paramInt = i;
      if (this.RTm != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RTm);
      }
      i = paramInt;
      if (this.RTn != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RTn);
      }
      paramInt = i;
      if (this.RTo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RTo);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.lpx) + g.a.a.b.b.a.bM(8, this.CreateTime);
      paramInt = i;
      if (this.Tua != null) {
        paramInt = i + g.a.a.a.oD(9, this.Tua.computeSize());
      }
      i = paramInt;
      if (this.Tub != null) {
        i = paramInt + g.a.a.a.oD(10, this.Tub.computeSize());
      }
      paramInt = i;
      if (this.Tuc != null) {
        paramInt = i + g.a.a.a.oD(11, this.Tuc.computeSize());
      }
      AppMethodBeat.o(205857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmo localcmo = (cmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205857);
          return -1;
        case 1: 
          localcmo.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 2: 
          localcmo.RTi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 3: 
          localcmo.RTk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 4: 
          localcmo.RTm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 5: 
          localcmo.RTn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 6: 
          localcmo.RTo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205857);
          return 0;
        case 7: 
          localcmo.lpx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205857);
          return 0;
        case 8: 
          localcmo.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205857);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbh)localObject2).parseFrom((byte[])localObject1);
            }
            localcmo.Tua = ((fbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205857);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcs)localObject2).parseFrom((byte[])localObject1);
            }
            localcmo.Tub = ((fcs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205857);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dle();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dle)localObject2).parseFrom((byte[])localObject1);
          }
          localcmo.Tuc = ((dle)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(205857);
        return 0;
      }
      AppMethodBeat.o(205857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmo
 * JD-Core Version:    0.7.0.1
 */