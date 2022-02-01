package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkc
  extends dyy
{
  public LinkedList<FinderContact> SGP;
  public int SSD;
  public LinkedList<FinderContact> SSd;
  public eae SUZ;
  public abv SVf;
  public aqn SVg;
  public int continueFlag;
  public LinkedList<aqt> wqP;
  
  public bkc()
  {
    AppMethodBeat.i(169062);
    this.SGP = new LinkedList();
    this.SSd = new LinkedList();
    this.wqP = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SVf != null)
      {
        paramVarArgs.oE(2, this.SVf.computeSize());
        this.SVf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.continueFlag);
      if (this.SUZ != null)
      {
        paramVarArgs.oE(4, this.SUZ.computeSize());
        this.SUZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.SGP);
      paramVarArgs.e(6, 8, this.SSd);
      paramVarArgs.e(7, 8, this.wqP);
      paramVarArgs.aY(8, this.SSD);
      if (this.SVg != null)
      {
        paramVarArgs.oE(9, this.SVg.computeSize());
        this.SVg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1128;
      }
    }
    label1128:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SVf != null) {
        i = paramInt + g.a.a.a.oD(2, this.SVf.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.continueFlag);
      paramInt = i;
      if (this.SUZ != null) {
        paramInt = i + g.a.a.a.oD(4, this.SUZ.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.SGP) + g.a.a.a.c(6, 8, this.SSd) + g.a.a.a.c(7, 8, this.wqP) + g.a.a.b.b.a.bM(8, this.SSD);
      paramInt = i;
      if (this.SVg != null) {
        paramInt = i + g.a.a.a.oD(9, this.SVg.computeSize());
      }
      AppMethodBeat.o(169063);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGP.clear();
        this.SSd.clear();
        this.wqP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkc localbkc = (bkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbkc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abv)localObject2).parseFrom((byte[])localObject1);
            }
            localbkc.SVf = ((abv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localbkc.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
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
            localbkc.SUZ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
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
            localbkc.SGP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
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
            localbkc.SSd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqt)localObject2).parseFrom((byte[])localObject1);
            }
            localbkc.wqP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 8: 
          localbkc.SSD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169063);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqn)localObject2).parseFrom((byte[])localObject1);
          }
          localbkc.SVg = ((aqn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkc
 * JD-Core Version:    0.7.0.1
 */