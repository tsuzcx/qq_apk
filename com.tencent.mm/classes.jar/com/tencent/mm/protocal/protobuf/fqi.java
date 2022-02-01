package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqi
  extends esc
{
  public String ZhF;
  public int aaCD;
  public String abQf;
  public String abQg;
  public fbx abQh;
  public String abQi;
  public com.tencent.mm.bx.b abQj;
  public String abQk;
  public eut abQl;
  public String abht;
  public String abrx;
  public String errmsg;
  public int hGE;
  public int scene;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hGE);
      if (this.errmsg != null) {
        paramVarArgs.g(3, this.errmsg);
      }
      if (this.abQf != null) {
        paramVarArgs.g(4, this.abQf);
      }
      if (this.abQg != null) {
        paramVarArgs.g(5, this.abQg);
      }
      if (this.abQh != null)
      {
        paramVarArgs.qD(6, this.abQh.computeSize());
        this.abQh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.version);
      if (this.abQi != null) {
        paramVarArgs.g(8, this.abQi);
      }
      paramVarArgs.bS(9, this.aaCD);
      if (this.abht != null) {
        paramVarArgs.g(10, this.abht);
      }
      if (this.abrx != null) {
        paramVarArgs.g(11, this.abrx);
      }
      if (this.ZhF != null) {
        paramVarArgs.g(12, this.ZhF);
      }
      if (this.abQj != null) {
        paramVarArgs.d(13, this.abQj);
      }
      paramVarArgs.bS(14, this.scene);
      if (this.abQk != null) {
        paramVarArgs.g(15, this.abQk);
      }
      if (this.abQl != null)
      {
        paramVarArgs.qD(16, this.abQl.computeSize());
        this.abQl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1336;
      }
    }
    label1336:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hGE);
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.errmsg);
      }
      i = paramInt;
      if (this.abQf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abQf);
      }
      paramInt = i;
      if (this.abQg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abQg);
      }
      i = paramInt;
      if (this.abQh != null) {
        i = paramInt + i.a.a.a.qC(6, this.abQh.computeSize());
      }
      i += i.a.a.b.b.a.cJ(7, this.version);
      paramInt = i;
      if (this.abQi != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abQi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aaCD);
      paramInt = i;
      if (this.abht != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abht);
      }
      i = paramInt;
      if (this.abrx != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abrx);
      }
      paramInt = i;
      if (this.ZhF != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZhF);
      }
      i = paramInt;
      if (this.abQj != null) {
        i = paramInt + i.a.a.b.b.a.c(13, this.abQj);
      }
      i += i.a.a.b.b.a.cJ(14, this.scene);
      paramInt = i;
      if (this.abQk != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.abQk);
      }
      i = paramInt;
      if (this.abQl != null) {
        i = paramInt + i.a.a.a.qC(16, this.abQl.computeSize());
      }
      AppMethodBeat.o(152714);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fqi localfqi = (fqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localfqi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localfqi.hGE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localfqi.errmsg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localfqi.abQf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localfqi.abQg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbx)localObject2).parseFrom((byte[])localObject1);
            }
            localfqi.abQh = ((fbx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 7: 
          localfqi.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152714);
          return 0;
        case 8: 
          localfqi.abQi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 9: 
          localfqi.aaCD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152714);
          return 0;
        case 10: 
          localfqi.abht = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 11: 
          localfqi.abrx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 12: 
          localfqi.ZhF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 13: 
          localfqi.abQj = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(152714);
          return 0;
        case 14: 
          localfqi.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152714);
          return 0;
        case 15: 
          localfqi.abQk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152714);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eut();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eut)localObject2).parseFrom((byte[])localObject1);
          }
          localfqi.abQl = ((eut)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqi
 * JD-Core Version:    0.7.0.1
 */