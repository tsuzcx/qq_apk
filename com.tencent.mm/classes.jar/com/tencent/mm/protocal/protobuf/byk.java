package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byk
  extends cld
{
  public String DLH;
  public dac DVe;
  public LinkedList<pl> DVf;
  public String DVg;
  public String DVh;
  public String DVi;
  public dac DVj;
  public String DVk;
  
  public byk()
  {
    AppMethodBeat.i(117890);
    this.DVf = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DLH != null) {
        paramVarArgs.d(2, this.DLH);
      }
      if (this.DVe != null)
      {
        paramVarArgs.kX(3, this.DVe.computeSize());
        this.DVe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.DVf);
      if (this.DVg != null) {
        paramVarArgs.d(5, this.DVg);
      }
      if (this.DVh != null) {
        paramVarArgs.d(6, this.DVh);
      }
      if (this.DVi != null) {
        paramVarArgs.d(7, this.DVi);
      }
      if (this.DVj != null)
      {
        paramVarArgs.kX(8, this.DVj.computeSize());
        this.DVj.writeFields(paramVarArgs);
      }
      if (this.DVk != null) {
        paramVarArgs.d(9, this.DVk);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DLH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DLH);
      }
      i = paramInt;
      if (this.DVe != null) {
        i = paramInt + f.a.a.a.kW(3, this.DVe.computeSize());
      }
      i += f.a.a.a.c(4, 8, this.DVf);
      paramInt = i;
      if (this.DVg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DVg);
      }
      i = paramInt;
      if (this.DVh != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DVh);
      }
      paramInt = i;
      if (this.DVi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DVi);
      }
      i = paramInt;
      if (this.DVj != null) {
        i = paramInt + f.a.a.a.kW(8, this.DVj.computeSize());
      }
      paramInt = i;
      if (this.DVk != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DVk);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byk localbyk = (byk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
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
            localbyk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localbyk.DLH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dac();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dac)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyk.DVe = ((dac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyk.DVf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localbyk.DVg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localbyk.DVh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localbyk.DVi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dac();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dac)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyk.DVj = ((dac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localbyk.DVk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byk
 * JD-Core Version:    0.7.0.1
 */