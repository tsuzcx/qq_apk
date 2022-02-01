package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class un
  extends esc
{
  public String OjY;
  public String Olm;
  public String Oln;
  public String Olo;
  public dfd YZV;
  public String hMy;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259104);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.YZV != null)
      {
        paramVarArgs.qD(4, this.YZV.computeSize());
        this.YZV.writeFields(paramVarArgs);
      }
      if (this.Olm != null) {
        paramVarArgs.g(5, this.Olm);
      }
      if (this.hMy != null) {
        paramVarArgs.g(6, this.hMy);
      }
      if (this.Oln != null) {
        paramVarArgs.g(7, this.Oln);
      }
      if (this.OjY != null) {
        paramVarArgs.g(8, this.OjY);
      }
      if (this.Olo != null) {
        paramVarArgs.g(9, this.Olo);
      }
      AppMethodBeat.o(259104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.YZV != null) {
        i = paramInt + i.a.a.a.qC(4, this.YZV.computeSize());
      }
      paramInt = i;
      if (this.Olm != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Olm);
      }
      i = paramInt;
      if (this.hMy != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.hMy);
      }
      paramInt = i;
      if (this.Oln != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Oln);
      }
      i = paramInt;
      if (this.OjY != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.OjY);
      }
      paramInt = i;
      if (this.Olo != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Olo);
      }
      AppMethodBeat.o(259104);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        un localun = (un)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259104);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localun.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259104);
          return 0;
        case 2: 
          localun.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259104);
          return 0;
        case 3: 
          localun.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259104);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfd)localObject2).parseFrom((byte[])localObject1);
            }
            localun.YZV = ((dfd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259104);
          return 0;
        case 5: 
          localun.Olm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259104);
          return 0;
        case 6: 
          localun.hMy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259104);
          return 0;
        case 7: 
          localun.Oln = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259104);
          return 0;
        case 8: 
          localun.OjY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259104);
          return 0;
        }
        localun.Olo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259104);
        return 0;
      }
      AppMethodBeat.o(259104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.un
 * JD-Core Version:    0.7.0.1
 */