package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bal
  extends com.tencent.mm.cd.a
{
  public int MFF;
  public int SCT;
  public baj SKZ;
  public int SMr;
  public dis SMs;
  public String description;
  public int endTime;
  public int extFlag;
  public String id;
  public int yaH;
  public int ycP;
  public int ynN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230640);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      paramVarArgs.aY(2, this.MFF);
      paramVarArgs.aY(3, this.endTime);
      paramVarArgs.aY(4, this.ynN);
      if (this.description != null) {
        paramVarArgs.f(5, this.description);
      }
      if (this.SKZ != null)
      {
        paramVarArgs.oE(6, this.SKZ.computeSize());
        this.SKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.yaH);
      paramVarArgs.aY(8, this.SCT);
      paramVarArgs.aY(9, this.ycP);
      paramVarArgs.aY(10, this.extFlag);
      paramVarArgs.aY(11, this.SMr);
      if (this.SMs != null)
      {
        paramVarArgs.oE(12, this.SMs.computeSize());
        this.SMs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.MFF) + g.a.a.b.b.a.bM(3, this.endTime) + g.a.a.b.b.a.bM(4, this.ynN);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.description);
      }
      i = paramInt;
      if (this.SKZ != null) {
        i = paramInt + g.a.a.a.oD(6, this.SKZ.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(7, this.yaH) + g.a.a.b.b.a.bM(8, this.SCT) + g.a.a.b.b.a.bM(9, this.ycP) + g.a.a.b.b.a.bM(10, this.extFlag) + g.a.a.b.b.a.bM(11, this.SMr);
      paramInt = i;
      if (this.SMs != null) {
        paramInt = i + g.a.a.a.oD(12, this.SMs.computeSize());
      }
      AppMethodBeat.o(230640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230640);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bal localbal = (bal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230640);
          return -1;
        case 1: 
          localbal.id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230640);
          return 0;
        case 2: 
          localbal.MFF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 3: 
          localbal.endTime = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 4: 
          localbal.ynN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 5: 
          localbal.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230640);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new baj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((baj)localObject2).parseFrom((byte[])localObject1);
            }
            localbal.SKZ = ((baj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230640);
          return 0;
        case 7: 
          localbal.yaH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 8: 
          localbal.SCT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 9: 
          localbal.ycP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 10: 
          localbal.extFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        case 11: 
          localbal.SMr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230640);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dis();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dis)localObject2).parseFrom((byte[])localObject1);
          }
          localbal.SMs = ((dis)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230640);
        return 0;
      }
      AppMethodBeat.o(230640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bal
 * JD-Core Version:    0.7.0.1
 */