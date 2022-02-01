package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgj
  extends dyy
{
  public long SpY;
  public long Tgi;
  public String Tgj;
  public String Tgk;
  public abx Tgl;
  public String Tnw;
  public boolean Tnx = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191837);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(191837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SpY);
      paramVarArgs.bm(3, this.Tgi);
      if (this.Tnw != null) {
        paramVarArgs.f(4, this.Tnw);
      }
      if (this.Tgj != null) {
        paramVarArgs.f(5, this.Tgj);
      }
      paramVarArgs.co(6, this.Tnx);
      if (this.Tgk != null) {
        paramVarArgs.f(7, this.Tgk);
      }
      if (this.Tgl != null)
      {
        paramVarArgs.oE(8, this.Tgl.computeSize());
        this.Tgl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(191837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SpY) + g.a.a.b.b.a.p(3, this.Tgi);
      paramInt = i;
      if (this.Tnw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tnw);
      }
      i = paramInt;
      if (this.Tgj != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tgj);
      }
      i += g.a.a.b.b.a.gL(6) + 1;
      paramInt = i;
      if (this.Tgk != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Tgk);
      }
      i = paramInt;
      if (this.Tgl != null) {
        i = paramInt + g.a.a.a.oD(8, this.Tgl.computeSize());
      }
      AppMethodBeat.o(191837);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(191837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(191837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgj localcgj = (cgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(191837);
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
            localcgj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(191837);
          return 0;
        case 2: 
          localcgj.SpY = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(191837);
          return 0;
        case 3: 
          localcgj.Tgi = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(191837);
          return 0;
        case 4: 
          localcgj.Tnw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(191837);
          return 0;
        case 5: 
          localcgj.Tgj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(191837);
          return 0;
        case 6: 
          localcgj.Tnx = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(191837);
          return 0;
        case 7: 
          localcgj.Tgk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(191837);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abx)localObject2).parseFrom((byte[])localObject1);
          }
          localcgj.Tgl = ((abx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(191837);
        return 0;
      }
      AppMethodBeat.o(191837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgj
 * JD-Core Version:    0.7.0.1
 */