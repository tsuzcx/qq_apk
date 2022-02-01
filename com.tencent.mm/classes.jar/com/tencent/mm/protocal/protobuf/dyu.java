package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dyu
  extends dpc
{
  public String MYh;
  public String MYi;
  public String MYj;
  public int MYt;
  public int MYu;
  public int MYv;
  public b MYw;
  public String Mbb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MYh != null) {
        paramVarArgs.e(2, this.MYh);
      }
      paramVarArgs.aM(3, this.MYt);
      paramVarArgs.aM(4, this.MYu);
      if (this.MYi != null) {
        paramVarArgs.e(5, this.MYi);
      }
      if (this.MYj != null) {
        paramVarArgs.e(6, this.MYj);
      }
      paramVarArgs.aM(7, this.MYv);
      if (this.Mbb != null) {
        paramVarArgs.e(8, this.Mbb);
      }
      if (this.MYw != null) {
        paramVarArgs.c(9, this.MYw);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MYh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MYh);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MYt) + g.a.a.b.b.a.bu(4, this.MYu);
      paramInt = i;
      if (this.MYi != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MYi);
      }
      i = paramInt;
      if (this.MYj != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MYj);
      }
      i += g.a.a.b.b.a.bu(7, this.MYv);
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mbb);
      }
      i = paramInt;
      if (this.MYw != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.MYw);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dyu localdyu = (dyu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdyu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localdyu.MYh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localdyu.MYt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localdyu.MYu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localdyu.MYi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localdyu.MYj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localdyu.MYv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localdyu.Mbb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localdyu.MYw = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyu
 * JD-Core Version:    0.7.0.1
 */