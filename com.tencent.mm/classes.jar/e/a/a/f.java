package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public String Khn;
  public String Kho;
  public String Khp;
  public String Khq;
  public String Khr;
  public int Khs;
  public e Kht;
  public b Khu;
  public b Khv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Khn != null) {
        paramVarArgs.d(1, this.Khn);
      }
      if (this.Kho != null) {
        paramVarArgs.d(2, this.Kho);
      }
      if (this.Khp != null) {
        paramVarArgs.d(3, this.Khp);
      }
      if (this.Khq != null) {
        paramVarArgs.d(4, this.Khq);
      }
      if (this.Khr != null) {
        paramVarArgs.d(5, this.Khr);
      }
      paramVarArgs.aR(6, this.Khs);
      if (this.Kht != null)
      {
        paramVarArgs.kX(7, this.Kht.computeSize());
        this.Kht.writeFields(paramVarArgs);
      }
      if (this.Khu != null) {
        paramVarArgs.c(8, this.Khu);
      }
      if (this.Khv != null) {
        paramVarArgs.c(9, this.Khv);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Khn == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.Khn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Kho != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Kho);
      }
      i = paramInt;
      if (this.Khp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Khp);
      }
      paramInt = i;
      if (this.Khq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Khq);
      }
      i = paramInt;
      if (this.Khr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Khr);
      }
      i += f.a.a.b.b.a.bA(6, this.Khs);
      paramInt = i;
      if (this.Kht != null) {
        paramInt = i + f.a.a.a.kW(7, this.Kht.computeSize());
      }
      i = paramInt;
      if (this.Khu != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.Khu);
      }
      paramInt = i;
      if (this.Khv != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.Khv);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.Khn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.Kho = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.Khp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.Khq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.Khr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.Khs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.Kht = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.Khu = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.Khv = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */