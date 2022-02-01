package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class feu
  extends dyy
{
  public int Svu;
  public long Svv;
  public int TWl;
  public LinkedList<fdb> UDx;
  public int UFq;
  public LinkedList<fdb> UFr;
  public int UFs;
  public LinkedList<fdb> UFt;
  public int UFu;
  public int UFv;
  public int UFw;
  public feo UFx;
  
  public feu()
  {
    AppMethodBeat.i(115907);
    this.UFr = new LinkedList();
    this.UFt = new LinkedList();
    this.UDx = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.aY(3, this.UFq);
      paramVarArgs.e(4, 8, this.UFr);
      paramVarArgs.aY(5, this.UFs);
      paramVarArgs.e(6, 8, this.UFt);
      paramVarArgs.bm(7, this.Svv);
      paramVarArgs.aY(8, this.TWl);
      paramVarArgs.aY(9, this.UFu);
      paramVarArgs.e(10, 8, this.UDx);
      paramVarArgs.aY(11, this.UFv);
      paramVarArgs.aY(12, this.UFw);
      if (this.UFx != null)
      {
        paramVarArgs.oE(13, this.UFx.computeSize());
        this.UFx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1168;
      }
    }
    label1168:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.bM(3, this.UFq) + g.a.a.a.c(4, 8, this.UFr) + g.a.a.b.b.a.bM(5, this.UFs) + g.a.a.a.c(6, 8, this.UFt) + g.a.a.b.b.a.p(7, this.Svv) + g.a.a.b.b.a.bM(8, this.TWl) + g.a.a.b.b.a.bM(9, this.UFu) + g.a.a.a.c(10, 8, this.UDx) + g.a.a.b.b.a.bM(11, this.UFv) + g.a.a.b.b.a.bM(12, this.UFw);
      paramInt = i;
      if (this.UFx != null) {
        paramInt = i + g.a.a.a.oD(13, this.UFx.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UFr.clear();
        this.UFt.clear();
        this.UDx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        feu localfeu = (feu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
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
            localfeu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localfeu.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localfeu.UFq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdb)localObject2).parseFrom((byte[])localObject1);
            }
            localfeu.UFr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localfeu.UFs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdb)localObject2).parseFrom((byte[])localObject1);
            }
            localfeu.UFt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localfeu.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localfeu.TWl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localfeu.UFu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdb)localObject2).parseFrom((byte[])localObject1);
            }
            localfeu.UDx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localfeu.UFv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localfeu.UFw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new feo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((feo)localObject2).parseFrom((byte[])localObject1);
          }
          localfeu.UFx = ((feo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      AppMethodBeat.o(115908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feu
 * JD-Core Version:    0.7.0.1
 */