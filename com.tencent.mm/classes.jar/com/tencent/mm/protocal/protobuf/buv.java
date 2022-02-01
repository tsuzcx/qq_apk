package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buv
  extends dpc
{
  public dsr Mbc;
  public dro Mbd;
  public drn Mbe;
  public dsu Mbf;
  public dsv Mbg;
  public drz Mbh;
  public dsa Mbi;
  public drw Mbj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mbc != null)
      {
        paramVarArgs.ni(2, this.Mbc.computeSize());
        this.Mbc.writeFields(paramVarArgs);
      }
      if (this.Mbd != null)
      {
        paramVarArgs.ni(3, this.Mbd.computeSize());
        this.Mbd.writeFields(paramVarArgs);
      }
      if (this.Mbe != null)
      {
        paramVarArgs.ni(4, this.Mbe.computeSize());
        this.Mbe.writeFields(paramVarArgs);
      }
      if (this.Mbf != null)
      {
        paramVarArgs.ni(5, this.Mbf.computeSize());
        this.Mbf.writeFields(paramVarArgs);
      }
      if (this.Mbg != null)
      {
        paramVarArgs.ni(6, this.Mbg.computeSize());
        this.Mbg.writeFields(paramVarArgs);
      }
      if (this.Mbh != null)
      {
        paramVarArgs.ni(7, this.Mbh.computeSize());
        this.Mbh.writeFields(paramVarArgs);
      }
      if (this.Mbi != null)
      {
        paramVarArgs.ni(8, this.Mbi.computeSize());
        this.Mbi.writeFields(paramVarArgs);
      }
      if (this.Mbj != null)
      {
        paramVarArgs.ni(9, this.Mbj.computeSize());
        this.Mbj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(187874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1550;
      }
    }
    label1550:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mbc != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mbc.computeSize());
      }
      i = paramInt;
      if (this.Mbd != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mbd.computeSize());
      }
      paramInt = i;
      if (this.Mbe != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mbe.computeSize());
      }
      i = paramInt;
      if (this.Mbf != null) {
        i = paramInt + g.a.a.a.nh(5, this.Mbf.computeSize());
      }
      paramInt = i;
      if (this.Mbg != null) {
        paramInt = i + g.a.a.a.nh(6, this.Mbg.computeSize());
      }
      i = paramInt;
      if (this.Mbh != null) {
        i = paramInt + g.a.a.a.nh(7, this.Mbh.computeSize());
      }
      paramInt = i;
      if (this.Mbi != null) {
        paramInt = i + g.a.a.a.nh(8, this.Mbi.computeSize());
      }
      i = paramInt;
      if (this.Mbj != null) {
        i = paramInt + g.a.a.a.nh(9, this.Mbj.computeSize());
      }
      AppMethodBeat.o(187874);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buv localbuv = (buv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187874);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbc = ((dsr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dro();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dro)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbd = ((dro)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbe = ((drn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbf = ((dsu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbg = ((dsv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbh = ((drz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dsa();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dsa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbuv.Mbi = ((dsa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187874);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new drw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((drw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbuv.Mbj = ((drw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(187874);
        return 0;
      }
      AppMethodBeat.o(187874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buv
 * JD-Core Version:    0.7.0.1
 */