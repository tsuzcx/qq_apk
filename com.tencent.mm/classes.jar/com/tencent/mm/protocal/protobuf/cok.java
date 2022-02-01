package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cok
  extends cld
{
  public LinkedList<dwd> CAD;
  public int DYI;
  public boolean Dwd;
  public int Efh;
  public dvu Eiq;
  public int Eir;
  public com.tencent.mm.bx.b Eis;
  public String Eit;
  public String Title;
  public int mAK;
  public int mBH;
  public int mBk;
  public int oXv;
  
  public cok()
  {
    AppMethodBeat.i(117922);
    this.CAD = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBk);
      paramVarArgs.aR(3, this.mBH);
      paramVarArgs.aR(4, this.DYI);
      paramVarArgs.aR(5, this.mAK);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.Eiq != null)
      {
        paramVarArgs.kX(7, this.Eiq.computeSize());
        this.Eiq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.CAD);
      paramVarArgs.aR(9, this.Efh);
      paramVarArgs.aR(10, this.Eir);
      paramVarArgs.bg(11, this.Dwd);
      if (this.Eis != null) {
        paramVarArgs.c(12, this.Eis);
      }
      paramVarArgs.aR(13, this.oXv);
      if (this.Eit != null) {
        paramVarArgs.d(14, this.Eit);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBk) + f.a.a.b.b.a.bA(3, this.mBH) + f.a.a.b.b.a.bA(4, this.DYI) + f.a.a.b.b.a.bA(5, this.mAK);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt;
      if (this.Eiq != null) {
        i = paramInt + f.a.a.a.kW(7, this.Eiq.computeSize());
      }
      i = i + f.a.a.a.c(8, 8, this.CAD) + f.a.a.b.b.a.bA(9, this.Efh) + f.a.a.b.b.a.bA(10, this.Eir) + (f.a.a.b.b.a.fY(11) + 1);
      paramInt = i;
      if (this.Eis != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.Eis);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.oXv);
      paramInt = i;
      if (this.Eit != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Eit);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CAD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cok localcok = (cok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localcok.mBk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localcok.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localcok.DYI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localcok.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localcok.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcok.Eiq = ((dvu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcok.CAD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localcok.Efh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localcok.Eir = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localcok.Dwd = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localcok.Eis = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localcok.oXv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117923);
          return 0;
        }
        localcok.Eit = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cok
 * JD-Core Version:    0.7.0.1
 */