package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsi
  extends dyy
{
  public dzq TcA;
  public String TcB;
  public dzo TcC;
  public String Tcy;
  public int Tcz;
  public long hDC;
  public int iWn;
  public String iWo;
  public int iWp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tcy != null) {
        paramVarArgs.f(2, this.Tcy);
      }
      paramVarArgs.aY(3, this.iWn);
      if (this.iWo != null) {
        paramVarArgs.f(4, this.iWo);
      }
      paramVarArgs.aY(5, this.iWp);
      paramVarArgs.aY(6, this.Tcz);
      paramVarArgs.bm(7, this.hDC);
      if (this.TcA != null)
      {
        paramVarArgs.oE(8, this.TcA.computeSize());
        this.TcA.writeFields(paramVarArgs);
      }
      if (this.TcB != null) {
        paramVarArgs.f(9, this.TcB);
      }
      if (this.TcC != null)
      {
        paramVarArgs.oE(10, this.TcC.computeSize());
        this.TcC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label964;
      }
    }
    label964:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tcy != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Tcy);
      }
      i += g.a.a.b.b.a.bM(3, this.iWn);
      paramInt = i;
      if (this.iWo != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.iWo);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.iWp) + g.a.a.b.b.a.bM(6, this.Tcz) + g.a.a.b.b.a.p(7, this.hDC);
      paramInt = i;
      if (this.TcA != null) {
        paramInt = i + g.a.a.a.oD(8, this.TcA.computeSize());
      }
      i = paramInt;
      if (this.TcB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TcB);
      }
      paramInt = i;
      if (this.TcC != null) {
        paramInt = i + g.a.a.a.oD(10, this.TcC.computeSize());
      }
      AppMethodBeat.o(101808);
      return paramInt;
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
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsi localbsi = (bsi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localbsi.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localbsi.Tcy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localbsi.iWn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localbsi.iWo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localbsi.iWp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localbsi.Tcz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localbsi.hDC = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzq)localObject2).parseFrom((byte[])localObject1);
            }
            localbsi.TcA = ((dzq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 9: 
          localbsi.TcB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzo)localObject2).parseFrom((byte[])localObject1);
          }
          localbsi.TcC = ((dzo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsi
 * JD-Core Version:    0.7.0.1
 */