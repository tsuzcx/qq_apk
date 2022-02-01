package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class euv
  extends dyy
{
  public String SjB;
  public String TQU;
  public int Tow;
  public String Uav;
  public ehx UwA;
  public String UwB;
  public com.tencent.mm.cd.b UwC;
  public String UwD;
  public String Uwy;
  public String Uwz;
  public String errmsg;
  public int fBP;
  public int scene;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fBP);
      if (this.errmsg != null) {
        paramVarArgs.f(3, this.errmsg);
      }
      if (this.Uwy != null) {
        paramVarArgs.f(4, this.Uwy);
      }
      if (this.Uwz != null) {
        paramVarArgs.f(5, this.Uwz);
      }
      if (this.UwA != null)
      {
        paramVarArgs.oE(6, this.UwA.computeSize());
        this.UwA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.version);
      if (this.UwB != null) {
        paramVarArgs.f(8, this.UwB);
      }
      paramVarArgs.aY(9, this.Tow);
      if (this.TQU != null) {
        paramVarArgs.f(10, this.TQU);
      }
      if (this.Uav != null) {
        paramVarArgs.f(11, this.Uav);
      }
      if (this.SjB != null) {
        paramVarArgs.f(12, this.SjB);
      }
      if (this.UwC != null) {
        paramVarArgs.c(13, this.UwC);
      }
      paramVarArgs.aY(14, this.scene);
      if (this.UwD != null) {
        paramVarArgs.f(15, this.UwD);
      }
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fBP);
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.errmsg);
      }
      i = paramInt;
      if (this.Uwy != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Uwy);
      }
      paramInt = i;
      if (this.Uwz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Uwz);
      }
      i = paramInt;
      if (this.UwA != null) {
        i = paramInt + g.a.a.a.oD(6, this.UwA.computeSize());
      }
      i += g.a.a.b.b.a.bM(7, this.version);
      paramInt = i;
      if (this.UwB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UwB);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Tow);
      paramInt = i;
      if (this.TQU != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TQU);
      }
      i = paramInt;
      if (this.Uav != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Uav);
      }
      paramInt = i;
      if (this.SjB != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SjB);
      }
      i = paramInt;
      if (this.UwC != null) {
        i = paramInt + g.a.a.b.b.a.b(13, this.UwC);
      }
      i += g.a.a.b.b.a.bM(14, this.scene);
      paramInt = i;
      if (this.UwD != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.UwD);
      }
      AppMethodBeat.o(152714);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euv localeuv = (euv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localeuv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localeuv.fBP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localeuv.errmsg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localeuv.Uwy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localeuv.Uwz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehx)localObject2).parseFrom((byte[])localObject1);
            }
            localeuv.UwA = ((ehx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 7: 
          localeuv.version = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152714);
          return 0;
        case 8: 
          localeuv.UwB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 9: 
          localeuv.Tow = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152714);
          return 0;
        case 10: 
          localeuv.TQU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 11: 
          localeuv.Uav = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 12: 
          localeuv.SjB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 13: 
          localeuv.UwC = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(152714);
          return 0;
        case 14: 
          localeuv.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152714);
          return 0;
        }
        localeuv.UwD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euv
 * JD-Core Version:    0.7.0.1
 */