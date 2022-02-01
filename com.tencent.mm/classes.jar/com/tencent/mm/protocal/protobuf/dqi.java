package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqi
  extends cwj
{
  public String HXd;
  public int HXk;
  public LinkedList<bss> HXl;
  public bss HXm;
  public int oGt;
  public String oGu;
  public String subtitle;
  public String title;
  
  public dqi()
  {
    AppMethodBeat.i(72603);
    this.HXl = new LinkedList();
    AppMethodBeat.o(72603);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72604);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(5, this.subtitle);
      }
      paramVarArgs.aS(6, this.HXk);
      paramVarArgs.e(7, 8, this.HXl);
      if (this.HXm != null)
      {
        paramVarArgs.lJ(8, this.HXm.computeSize());
        this.HXm.writeFields(paramVarArgs);
      }
      if (this.HXd != null) {
        paramVarArgs.d(9, this.HXd);
      }
      AppMethodBeat.o(72604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.subtitle != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.subtitle);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HXk) + f.a.a.a.c(7, 8, this.HXl);
      paramInt = i;
      if (this.HXm != null) {
        paramInt = i + f.a.a.a.lI(8, this.HXm.computeSize());
      }
      i = paramInt;
      if (this.HXd != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HXd);
      }
      AppMethodBeat.o(72604);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HXl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72604);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqi localdqi = (dqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72604);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 2: 
          localdqi.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72604);
          return 0;
        case 3: 
          localdqi.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 4: 
          localdqi.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 5: 
          localdqi.subtitle = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72604);
          return 0;
        case 6: 
          localdqi.HXk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72604);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqi.HXl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqi.HXm = ((bss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72604);
          return 0;
        }
        localdqi.HXd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72604);
        return 0;
      }
      AppMethodBeat.o(72604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqi
 * JD-Core Version:    0.7.0.1
 */