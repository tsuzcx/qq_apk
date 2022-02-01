package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhr
  extends erp
{
  public String IMg;
  public String IMh;
  public String YHk;
  public int abIu;
  public int abIv;
  public LinkedList<fht> abIw;
  public fhq abIx;
  public int abIy;
  public LinkedList<fhq> abIz;
  
  public fhr()
  {
    AppMethodBeat.i(152697);
    this.abIw = new LinkedList();
    this.abIz = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abIu);
      if (this.IMh != null) {
        paramVarArgs.g(3, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      if (this.YHk != null) {
        paramVarArgs.g(5, this.YHk);
      }
      paramVarArgs.bS(6, this.abIv);
      paramVarArgs.e(7, 8, this.abIw);
      if (this.abIx != null)
      {
        paramVarArgs.qD(8, this.abIx.computeSize());
        this.abIx.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.abIy);
      paramVarArgs.e(10, 8, this.abIz);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abIu);
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IMg);
      }
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YHk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abIv) + i.a.a.a.c(7, 8, this.abIw);
      paramInt = i;
      if (this.abIx != null) {
        paramInt = i + i.a.a.a.qC(8, this.abIx.computeSize());
      }
      i = i.a.a.b.b.a.cJ(9, this.abIy);
      int j = i.a.a.a.c(10, 8, this.abIz);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abIw.clear();
        this.abIz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fhr localfhr = (fhr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfhr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localfhr.abIu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localfhr.IMh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localfhr.IMg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localfhr.YHk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localfhr.abIv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fht)localObject2).parseFrom((byte[])localObject1);
            }
            localfhr.abIw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhq)localObject2).parseFrom((byte[])localObject1);
            }
            localfhr.abIx = ((fhq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localfhr.abIy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhq)localObject2).parseFrom((byte[])localObject1);
          }
          localfhr.abIz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhr
 * JD-Core Version:    0.7.0.1
 */