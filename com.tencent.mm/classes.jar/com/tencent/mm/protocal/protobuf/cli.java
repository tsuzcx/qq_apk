package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cli
  extends cwj
{
  public long COr;
  public String COs;
  public String COu;
  public String COv;
  public iu HxA;
  public int HxB;
  public LinkedList<clj> Hxz;
  public int oGt;
  public String oGu;
  
  public cli()
  {
    AppMethodBeat.i(91616);
    this.Hxz = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.e(4, 8, this.Hxz);
      paramVarArgs.aZ(5, this.COr);
      if (this.COs != null) {
        paramVarArgs.d(6, this.COs);
      }
      if (this.HxA != null)
      {
        paramVarArgs.lJ(7, this.HxA.computeSize());
        this.HxA.writeFields(paramVarArgs);
      }
      if (this.COu != null) {
        paramVarArgs.d(8, this.COu);
      }
      if (this.COv != null) {
        paramVarArgs.d(9, this.COv);
      }
      paramVarArgs.aS(10, this.HxB);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Hxz) + f.a.a.b.b.a.p(5, this.COr);
      paramInt = i;
      if (this.COs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.COs);
      }
      i = paramInt;
      if (this.HxA != null) {
        i = paramInt + f.a.a.a.lI(7, this.HxA.computeSize());
      }
      paramInt = i;
      if (this.COu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.COu);
      }
      i = paramInt;
      if (this.COv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.COv);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.HxB);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hxz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cli localcli = (cli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localcli.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localcli.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localcli.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcli.Hxz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localcli.COr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localcli.COs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcli.HxA = ((iu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localcli.COu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localcli.COv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localcli.HxB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cli
 * JD-Core Version:    0.7.0.1
 */