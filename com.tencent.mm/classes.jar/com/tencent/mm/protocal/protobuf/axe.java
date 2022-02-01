package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class axe
  extends cpx
{
  public String DZy;
  public cdt EOb;
  public int EPd;
  public String EPe;
  public b EPf;
  public String Epl;
  public String action_data;
  public String oGB;
  public String person_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.d(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(3, this.action_data);
      }
      paramVarArgs.aR(4, this.EPd);
      if (this.EPe != null) {
        paramVarArgs.d(5, this.EPe);
      }
      if (this.DZy != null) {
        paramVarArgs.d(6, this.DZy);
      }
      paramVarArgs.aR(7, this.scene);
      if (this.Epl != null) {
        paramVarArgs.d(8, this.Epl);
      }
      if (this.oGB != null) {
        paramVarArgs.d(9, this.oGB);
      }
      if (this.EOb != null)
      {
        paramVarArgs.ln(10, this.EOb.computeSize());
        this.EOb.writeFields(paramVarArgs);
      }
      if (this.EPf != null) {
        paramVarArgs.c(11, this.EPf);
      }
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label986;
      }
    }
    label986:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action_data);
      }
      i += f.a.a.b.b.a.bx(4, this.EPd);
      paramInt = i;
      if (this.EPe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EPe);
      }
      i = paramInt;
      if (this.DZy != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DZy);
      }
      i += f.a.a.b.b.a.bx(7, this.scene);
      paramInt = i;
      if (this.Epl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Epl);
      }
      i = paramInt;
      if (this.oGB != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oGB);
      }
      paramInt = i;
      if (this.EOb != null) {
        paramInt = i + f.a.a.a.lm(10, this.EOb.computeSize());
      }
      i = paramInt;
      if (this.EPf != null) {
        i = paramInt + f.a.a.b.b.a.b(11, this.EPf);
      }
      AppMethodBeat.o(104371);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axe localaxe = (axe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxe.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localaxe.person_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localaxe.action_data = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localaxe.EPd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localaxe.EPe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localaxe.DZy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localaxe.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localaxe.Epl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localaxe.oGB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxe.EOb = ((cdt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        }
        localaxe.EPf = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axe
 * JD-Core Version:    0.7.0.1
 */